package org.example;
import java.util.ArrayList;

/**
 * Clase que representa un producto en la tienda.
 * Contiene atributos básicos como ID, nombre, precio y cantidad,
 * y métodos para obtener y modificar estos valores.
 */

public class Producto{

    // 2.	Crea una clase Producto con los atributos: id, nombre, precio, y cantidad
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;


    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters y Setters para los atributos del producto
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

}
