package console;

import model.Cliente;
import model.CarritoDeCompra;
import model.CarritoItem;
import model.Producto;
import model.Pedido;
import java.util.Scanner;
import model.Inventario;

public class UserApp {
    private Cliente cliente;
    private CarritoDeCompra carrito;
    private Inventario inventario;
    private static Scanner sc = new Scanner(System.in);

    public UserApp() {
        this.carrito = new CarritoDeCompra();
        this.inventario = new Inventario();
    }

    public UserApp(Inventario inventario) {
        this.carrito = new CarritoDeCompra();
        this.inventario = inventario;
    }
    
    public static void main(String[] args) {
        UserApp app = new UserApp(); 
        app.mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Ver Productos");
            System.out.println("4. Agregar Producto al Carrito");
            System.out.println("5. Eliminar Producto del Carrito");
            System.out.println("6. Ver Carrito");
            System.out.println("7. Realizar Pedido");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarse();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    verProductos();
                    break;
                 case 4:
                    agregarProductoACarrito();
                    break;
                case 5:
                    eliminarProductoDeCarrito();
                    break;
                case 6:
                    verCarrito();
                    break;
                case 7:
                    realizarPedido();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    public void registrarse() {
        this.cliente = new Cliente();
        cliente.registrarse();
        System.out.println("Usuario registrado correctamente: " + cliente.getNombre());
    }

    public void iniciarSesion() {
        System.out.println("Introduce tu email: ");
        String email = sc.next();
        System.out.println("Introduce tu password: ");
        String password = sc.next();

        cliente.iniciarSesion(email, password);
    }

    public void verProductos() {
        System.out.println("Productos disponibles:");
        inventario.listarInventario();
    }

    public void agregarProductoACarrito() {
        System.out.println("Introduce el ID del producto: ");
        String idProducto = sc.next();
    
        System.out.println("Introduce la cantidad: ");
        int cantidad = sc.nextInt();
    
        Producto producto = inventario.buscarProductoPorId(idProducto);
    
        if (producto != null) {
            CarritoItem item = new CarritoItem(producto, cantidad);
            carrito.agregarProducto(item);
            System.out.println("Producto agregado al carrito: " + producto.getNombre() + ", cantidad: " + cantidad);
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }
    
    public void eliminarProductoDeCarrito() {
        System.out.println("Introduce el ID del producto a eliminar: ");
        String idProducto = sc.next();
    
        Producto producto = inventario.buscarProductoPorId(idProducto);
    
        if (producto != null) {
            System.out.println("Introduce la cantidad a eliminar: ");
            int cantidad = sc.nextInt();
            carrito.eliminarProducto(producto, cantidad); 
        } else {
            System.out.println("Producto no encontrado en el inventario.");
        }
    }

    public void verCarrito() {
        if (carrito.getItems().isEmpty()) {
            System.out.println("El carrito está vacío.");
        } else {
            System.out.println(carrito); 
        }
    }
        
    public void realizarPedido() {
        if (carrito.getItems().isEmpty()) {
            System.out.println("El carrito está vacío. No puedes realizar un pedido.");
            return;
        }
    
        Pedido pedido = carrito.convertirEnPedido(cliente.getId());
    
        System.out.println("\nDetalles del Pedido:");
        System.out.println(pedido);
    
        System.out.println("¿Confirmar pedido? (s/n): ");
        String respuesta = sc.next().toLowerCase();
    
        if (pedido.realizarPedido(respuesta)) {
            System.out.println("¡Pedido confirmado y pagado con éxito!");
            carrito.vaciarCarrito(); 
        } else {
            System.out.println("El pedido ha sido cancelado.");
        }
    }

}
