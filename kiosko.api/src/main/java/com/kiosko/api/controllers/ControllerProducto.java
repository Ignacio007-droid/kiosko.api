package com.kiosko.api.controllers;

import com.kiosko.api.objets.Categoria;
import com.kiosko.api.objets.Producto;
import com.kiosko.api.objets.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kiosko.api.services.ProductoService;


import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")//permite peticiones desde otros orígenes
public class ControllerProducto {

    private final ProductoService productoService;

    public ControllerProducto(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listar(@RequestParam(required = false) Categoria categoria) {
        if (categoria != null) {
            return productoService.obtenerPorCategoria(categoria);
        }
        return productoService.listarTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crear(@RequestBody ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setImagenURL(dto.getImagenUrl());
        producto.setCategoria(dto.getCategoria());

        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        return productoService.obtenerPorId(id).map(producto -> {
            producto.setNombre(dto.getNombre());
            producto.setPrecio(dto.getPrecio());
            producto.setImagenURL(dto.getImagenUrl());
            producto.setCategoria(dto.getCategoria());
            return ResponseEntity.ok(productoService.guardar(producto));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (productoService.validarPorId(id)) {
            productoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
