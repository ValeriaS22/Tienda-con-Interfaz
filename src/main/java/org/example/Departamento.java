package org.example;
import java.util.ArrayList;

public class Departamento implements GestionProducto{
    private String nombre; // Nombre del departamento
    private ArrayList<Producto> productos; // Lista de productos en este departamento


    public Departamento(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    // Métodos getter y setter para el nombre del departamento
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


     // Agrega un producto al departamento

    @Override
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto);
    }


     // Elimina un producto del departamento por su ID.

    @Override
    public void eliminarProducto(int idProducto) {
        Producto producto = buscarProductoPorId(idProducto);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto);
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
        }
    }

    // Actualiza el precio de un producto por su ID

    @Override
    public void actualizarPrecio(int idProducto, double nuevoPrecio) {
        Producto producto = buscarProductoPorId(idProducto);
        if (producto != null) {
            producto.setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado: " + producto);
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
        }
    }


    // Busca un producto en el departamento por su ID.
    @Override
    public Producto buscarProductoPorId(int idProducto) {
        for (Producto producto : productos) {
            if (producto.getId() == idProducto) {
                return producto;
            }
        }
        return null;
    }


     // Muestra todos los productos en el departamento
    @Override
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el departamento.");
        } else {
            System.out.println("Productos en el departamento " + nombre + ":");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    // como tal el departamento
    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", cantidad de productos=" + productos.size() +
                '}';
    }
}

