package Controllers;

import Objets.Producto;
import Interfaces.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
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
