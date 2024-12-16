package model;
/*@author nachogarren*/

public abstract class Producto {
    //PROPIEDADES
    private String id;
    private String nombre;
    private double precio;
    private String tamano;
    private String color;
    private String categoria;

    //CONSTRUCTORES
    public Producto() {
    }

    public Producto(String id, String nombre, double precio, String tamano, String color, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
        this.color = color;
        this.categoria = categoria;
    }
    
    // Getter y Setter para id
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para precio
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }
    

    // Getter y Setter para tamano
    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    // Getter y Setter para color
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // Getter y Setter para categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    //METODOS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id != null && id.equals(producto.id);  
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;  
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tamano='" + tamano + '\'' +
                ", color='" + color + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

}
