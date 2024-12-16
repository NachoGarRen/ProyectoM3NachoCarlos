package console;

import model.Producto;
import model.Inventario;

public class StockApp {
    private Inventario inventario;

    public StockApp(Inventario inventario) {
        this.inventario = inventario;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        inventario.agregarProducto(producto, cantidad);
        System.out.println("Producto agregado al inventario: " + producto.getNombre() + ", cantidad: " + cantidad);
    }

    public void eliminarProducto(Producto producto, int cantidad) {
        inventario.eliminarProducto(producto, cantidad);
        System.out.println("Producto eliminado del inventario: " + producto.getNombre() + ", cantidad: " + cantidad);
    }

    public void listarInventario() {
        System.out.println("Listado de productos en el inventario:");
        inventario.listarInventario();
    }

    public void verDetallesProducto(Producto producto) {
        int stock = inventario.consultarStock(producto);
        System.out.println("Detalles del producto:");
        System.out.println(producto);
        System.out.println("Stock disponible: " + stock);
    }

    public void actualizarStock(Producto producto, int nuevaCantidad) {
        inventario.actualizarStock(producto, nuevaCantidad);
    }
    
}
