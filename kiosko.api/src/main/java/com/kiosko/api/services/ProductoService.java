package com.kiosko.api.services;

import com.kiosko.api.objets.Categoria;
import com.kiosko.api.objets.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService{

    @Autowired
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> listarTodo() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public boolean validarPorId(Long id){
        return productoRepository.existsById(id);
    }

    public List<Producto> obtenerPorCategoria(Categoria categoria){
     return productoRepository.findByCategoria(categoria);
    }

    //, MultipartFile imagen) throws IOException  es para poder poner imagenes pero por ahora queda asi
    public Producto guardar(Producto producto){
       /* if (imagen != null && !imagen.isEmpty()) {

            String carpeta = "uploads/";
            File directorio = new File(carpeta);
            if (!directorio.exists()) directorio.mkdirs();

            String ruta = carpeta + imagen.getOriginalFilename();
            imagen.transferTo(new File(ruta));

            producto.setImagenURL(ruta);
        }*/
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}