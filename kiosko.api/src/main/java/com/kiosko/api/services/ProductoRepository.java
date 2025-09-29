package com.kiosko.api.services;

import com.kiosko.api.objets.Categoria;
import com.kiosko.api.objets.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoria(Categoria categoria);
}
//JpaRepository ya me da metodos como findAll(), findById(), save(), deleteById(), etc