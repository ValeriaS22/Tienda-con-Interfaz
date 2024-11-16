package org.example;

/**
 * Interfaz para gestionar productos en un departamento.
 * Define operaciones básicas como agregar, eliminar, actualizar precios y buscar productos.
 */

public interface GestionProducto {

    void agregarProducto(Producto producto);
    void eliminarProducto(int idProducto);
    void actualizarPrecio(int idProducto, double nuevoPrecio);
    Producto buscarProductoPorId(int idProducto);
    void mostrarProductos();
}
