package model;
import java.util.ArrayList;
import java.util.List;


public class CarritoDeCompra {
    private List<CarritoItem> items;

    // Constructor
    public CarritoDeCompra() {
        this.items = new ArrayList<>();
    }

    // Getters y setters
    public List<CarritoItem> getItems() {
        return items;
    }

    public void setItems(List<CarritoItem> items) {
        this.items = items;
    }


    //METODOS
    public void agregarProducto(CarritoItem item) {
        for (CarritoItem existingItem : items) {
            if (existingItem.getProducto().getId().equals(item.getProducto().getId())) {
                existingItem.setCantidad(existingItem.getCantidad() + item.getCantidad());
                return;
            }
        }
        items.add(item);
    }

    public void eliminarProducto(Producto producto, int cantidad) {
        for (CarritoItem item : items) {
            if (item.getProducto().getId().equals(producto.getId())) {
                if (item.getCantidad() > cantidad) {
                    item.setCantidad(item.getCantidad() - cantidad); 
                    System.out.println("Se eliminaron " + cantidad + " unidades de " + producto.getNombre());
                } else {
                    items.remove(item); 
                    System.out.println("Producto eliminado del carrito: " + producto.getNombre());
                }
                return;
            }
        }
        System.out.println("El producto no está en el carrito.");
    }
    
    public double calcularTotal() {
        double total = 0;
        for (CarritoItem item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void vaciarCarrito() {
        items.clear();
    }

    public Pedido convertirEnPedido(String idCliente) {
        Pedido pedido = new Pedido(idCliente, items);
        return pedido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito de Compra: \n");
        for (CarritoItem item : items) {
            sb.append(item.getProducto().getNombre())
              .append(" - Cantidad: ").append(item.getCantidad())
              .append(" - Subtotal: ").append(item.calcularSubtotal())
              .append("\n");
        }
        sb.append("Total: ").append(calcularTotal());
        return sb.toString();
    }
}
