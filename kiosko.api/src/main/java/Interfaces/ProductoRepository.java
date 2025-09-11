package Interfaces;

import Objets.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
//JpaRepository ya me da metodos como findAll(), findById(), save(), deleteById(), etc