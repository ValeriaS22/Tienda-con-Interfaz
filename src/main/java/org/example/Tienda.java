package org.example;
import java.util.ArrayList;


public class Tienda{
    private String nombre; // Nombre de la tienda
    private ArrayList<Departamento> departamentos; // Lista de departamentos en la tienda

    // getter para obtener los departamentos
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    // metodo constructor
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    // Métodos getter y setter para el nombre de la tienda
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


     // Agrega un departamento a la tienda.
    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
        System.out.println("Departamento agregado: " + departamento.getNombre());
    }


    // Muestra todos los departamentos en la tienda.
    public void consultarDepartamentos() {
        if (departamentos.isEmpty()) {
            System.out.println("No hay departamentos en la tienda.");
        } else {
            System.out.println("Departamentos en la tienda:");
            for (Departamento departamento : departamentos) {
                System.out.println("- " + departamento.getNombre());
            }
        }
    }


    //Muestra los productos en un departamento específico.
    public void consultarProductosEnDepartamento(String nombreDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getNombre().equalsIgnoreCase(nombreDepartamento)) {
                departamento.mostrarProductos();
                return;
            }
        }
        System.out.println("Departamento '" + nombreDepartamento + "' no encontrado.");
    }

    // como tal la tienda
    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", cantidad de departamentos=" + departamentos.size() +
                '}';
    }
}
