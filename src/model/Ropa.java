package model;

public class Ropa extends Producto {
    private String material;
    private String estilo;

    // Constructor
    public Ropa() {
    }

    public Ropa(String id, String nombre, double precio, String tamano, String color, String categoria, String material, String estilo) {
        super(id, nombre, precio, tamano, color, categoria);
        this.material = material;
        this.estilo = estilo;
    }

    // Getters y Setters
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    //METODOS
    @Override
    public String toString() {
        return super.toString() + ", Material: " + material + ", Estilo: " + estilo;
    }
}

