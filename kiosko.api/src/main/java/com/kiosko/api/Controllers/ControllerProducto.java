package com.kiosko.api.Controllers;

import com.kiosko.api.Objets.Producto;
import com.kiosko.api.Interfaces.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")//permite peticiones desde otros orígenes
public class ControllerProducto {

    private final ProductoRepository repo;

    public ControllerProducto(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> listar() {
        return repo.findAll();
    }
}
