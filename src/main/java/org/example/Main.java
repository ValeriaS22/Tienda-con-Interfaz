package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda("La tienda de Valeria");

        System.out.println("Bienvenido a " + tienda.getNombre() + "!");

        // Paso 1: Solicitar la cantidad de departamentos
        System.out.print("¿Cuántos departamentos desea agregar? ");
        int cantidadDepartamentos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        // Paso 2: Crear los departamentos
        for (int i = 0; i < cantidadDepartamentos; i++) {
            System.out.print("Ingrese el nombre del departamento " + (i + 1) + ": ");
            String nombreDepartamento = scanner.nextLine();
            Departamento departamento = new Departamento(nombreDepartamento);
            tienda.agregarDepartamento(departamento);

            // Paso 3: Agregar productos a este departamento
            boolean agregarMasProductos = true;
            while (agregarMasProductos) {
                System.out.print("¿Desea agregar un producto al departamento " + nombreDepartamento + "? (S/N): ");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.print("Ingrese el ID del producto: ");
                    int idProducto = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();

                    System.out.print("Ingrese el precio del producto: ");
                    double precioProducto = scanner.nextDouble();

                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidadProducto = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    Producto producto = new Producto(idProducto, nombreProducto, precioProducto, cantidadProducto);
                    departamento.agregarProducto(producto);  // Aquí se usa Departamento
                    System.out.println("Producto agregado correctamente.");
                } else {
                    agregarMasProductos = false;
                }
            }
        }

        // Menú Principal
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Consultar departamentos");
            System.out.println("2. Consultar productos de un departamento");
            System.out.println("3. Agregar un producto");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Actualizar el precio de un producto");
            System.out.println("6. Consultar stock de un producto");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    tienda.consultarDepartamentos();
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del departamento a consultar: ");
                    String deptoConsulta = scanner.nextLine();
                    tienda.consultarProductosEnDepartamento(deptoConsulta);
                    break;

                case 3:
                    // Agregar un producto
                    System.out.print("Ingrese el nombre del departamento donde desea agregar el producto: ");
                    String deptoNombre = scanner.nextLine();
                    Departamento depto = null;
                    for (Departamento d : tienda.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(deptoNombre)) {
                            depto = d;
                            break;
                        }
                    }

                    if (depto != null) {
                        System.out.print("Ingrese el ID del producto: ");
                        int idProducto = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreProducto = scanner.nextLine();

                        System.out.print("Ingrese el precio del producto: ");
                        double precioProducto = scanner.nextDouble();

                        System.out.print("Ingrese la cantidad del producto: ");
                        int cantidadProducto = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        Producto producto = new Producto(idProducto, nombreProducto, precioProducto, cantidadProducto);
                        depto.agregarProducto(producto);  // Llamando al agregar en la clase Departamento
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("El departamento no existe.");
                    }
                    break;

                case 4:
                    // Eliminar un producto
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    // Buscar y eliminar el producto
                    boolean productoEliminado = false;
                    for (Departamento d : tienda.getDepartamentos()) {
                        if (d.buscarProductoPorId(idEliminar) != null) {
                            d.eliminarProducto(idEliminar);  // Usar el eliminarProducto de Departamento
                            productoEliminado = true;
                            break;
                        }
                    }

                    if (!productoEliminado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    // Actualizar el precio de un producto
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    boolean productoActualizado = false;
                    for (Departamento d : tienda.getDepartamentos()) {
                        Producto producto = d.buscarProductoPorId(idActualizar);  // Usar el  buscarProductoPorId de Departamento
                        if (producto != null) {
                            d.actualizarPrecio(idActualizar, nuevoPrecio);  // Llamando a  actualizarPrecio de Departamento
                            productoActualizado = true;
                            break;
                        }
                    }

                    if (!productoActualizado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 6:
                    // Consultar stock de un producto
                    System.out.print("Ingrese el ID del producto para consultar su stock: ");
                    int idStock = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    boolean productoConStock = false;
                    for (Departamento d : tienda.getDepartamentos()) {
                        Producto producto = d.buscarProductoPorId(idStock);  // Usar buscarProductoPorId de Departamento
                        if (producto != null) {
                            System.out.println("Stock del producto: " + producto.getCantidad());
                            productoConStock = true;
                            break;
                        }
                    }

                    if (!productoConStock) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 7:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}