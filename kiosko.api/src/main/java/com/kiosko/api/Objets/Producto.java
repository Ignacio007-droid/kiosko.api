package com.kiosko.api.Objets;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double precio;
    private int cantidad;
    private String nombre;

    public Producto(){};
    public Producto(double precio , int cantidad, String nombre) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

