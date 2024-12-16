package model;

public class Accesorio extends Producto {
    private String tipo;

    // Constructor
    public Accesorio() {
    }

    public Accesorio(String id, String nombre, double precio, String tamano, String color, String categoria, String tipo) {
        super(id, nombre, precio, tamano, color, categoria);
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //METODOS
    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}

