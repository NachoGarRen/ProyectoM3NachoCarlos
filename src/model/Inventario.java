package model;
import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private Map<Producto, Integer> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }


    // Getters y setters
    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }

        // Métodos
        public void agregarProducto(Producto producto, int cantidad) {
            if (productos.containsKey(producto)) {
                productos.put(producto, productos.get(producto) + cantidad);
            } else {
                productos.put(producto, cantidad);
            }
            System.out.println("Producto agregado: " + producto.getNombre() + ", Cantidad: " + cantidad);
        }
    
        public void eliminarProducto(Producto producto, int cantidad) {
            if (productos.containsKey(producto)) {
                int cantidadActual = productos.get(producto);
                if (cantidadActual >= cantidad) {
                    productos.put(producto, cantidadActual - cantidad); 
                    System.out.println("Producto eliminado: " + producto.getNombre() + ", Cantidad: " + cantidad);
                } else {
                    System.out.println("No hay suficiente stock para eliminar.");
                }
            } else {
                System.out.println("El producto no está en el inventario.");
            }
        }

        public Producto buscarProductoPorNombre(String nombre) {
            for (Producto producto : productos.keySet()) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    return producto;
                }
            }
            return null;
        }
    
        public Producto buscarProductoPorId(String id) {
            for (Producto producto : productos.keySet()) { 
                if (producto.getId().equals(id)) {
                    return producto;
                }
            }
            return null; 
        }
                
        public void actualizarStock(Producto producto, int nuevaCantidad) {
            if (productos.containsKey(producto)) {
                productos.put(producto, nuevaCantidad); 
                System.out.println("Stock actualizado: " + producto.getNombre() + ", Nueva cantidad: " + nuevaCantidad);
            } else {
                System.out.println("El producto no está en el inventario.");
            }
        }
    
        public int consultarStock(Producto producto) {
            return productos.getOrDefault(producto, 0);
        }
    
        public void listarInventario() {
            if (productos.isEmpty()) {
                System.out.println("El inventario está vacío.");
            } else {
                System.out.println("Inventario:");
                for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
                    System.out.println("Producto: " + entry.getKey().getNombre() + ", Cantidad: " + entry.getValue() + ", ID: " + entry.getKey().getId());
                }
            }
        }

        
}

