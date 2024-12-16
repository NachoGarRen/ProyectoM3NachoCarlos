package console;

import model.Accesorio;
import model.Ropa;
import model.Producto;
import model.Inventario;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Inventario inventario = new Inventario(); 
    
    public static void main(String[] args) {
        UserApp userApp = new UserApp(inventario);
        StockApp stockApp = new StockApp(inventario);

        int opcion;

        do {
            System.out.println("\nMenú Principal:");
            System.out.println("1. UserApp");
            System.out.println("2. StockApp");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    userApp.mostrarMenu();
                    break;
                case 2:
                    mostrarMenuStockApp(stockApp);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenuStockApp(StockApp stockApp) {
        int opcion;

        do {
            System.out.println("\nMenú StockApp:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Listar Inventario");
            System.out.println("4. Ver Detalles de Producto");
            System.out.println("5. Actualizar Stock");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto(stockApp);
                    break;
                case 2:
                    eliminarProducto(stockApp);
                    break;
                case 3:
                    stockApp.listarInventario();
                    break;
                case 4:
                    verDetallesProducto(stockApp);
                    break;
                case 5:
                    actualizarStock(stockApp);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void agregarProducto(StockApp stockApp) {
        sc.nextLine(); 
        System.out.println("Selecciona el tipo de producto:");
        System.out.println("1. Ropa");
        System.out.println("2. Accesorio");
        System.out.print("Elige una opción: ");
        int tipoProducto = sc.nextInt();

        sc.nextLine(); 
        String id = String.valueOf((int)(Math.random() * 9000) + 1000);

        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Cantidad a agregar: ");
        int cantidad = sc.nextInt();

        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();

        System.out.print("Tamaño del producto: ");
        String tamano = sc.next();

        System.out.print("Color: ");
        String color = sc.next();

        System.out.print("Categoria del producto: ");
        String categoria = sc.next();

        Producto producto;

        if (tipoProducto == 1) {
            sc.nextLine();

            System.out.print("Material del producto: ");
            String material = sc.next();
    
            System.out.print("Estilo del producto: ");
            String estilo = sc.next();

            producto = new Ropa(id, nombre, precio, tamano, color, categoria, material, estilo); 
        } else if (tipoProducto == 2) {
            sc.nextLine();
            
            System.out.print("Tipo del producto: ");
            String tipo = sc.next();

            producto = new Accesorio(id, nombre, precio, tamano, color, categoria, tipo); 
        } else {
            System.out.println("Tipo de producto no válido. Operación cancelada.");
            return;
        }

        stockApp.agregarProducto(producto, cantidad);
    }

    private static void eliminarProducto(StockApp stockApp) {
        sc.nextLine();
        System.out.print("ID del producto a eliminar: ");
        String id = sc.nextLine();

        Producto producto = inventario.buscarProductoPorId(id);
        if (producto != null) {
            System.out.print("Cantidad a eliminar: ");
            int cantidad = sc.nextInt();    
            stockApp.eliminarProducto(producto, cantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void verDetallesProducto(StockApp stockApp) {
        sc.nextLine(); 
        System.out.print("ID del producto: ");
        String id = sc.nextLine();

        Producto producto = inventario.buscarProductoPorId(id);
        if (producto != null) {
            stockApp.verDetallesProducto(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    private static void actualizarStock(StockApp stockApp) {
        sc.nextLine(); 
        System.out.print("ID del producto para actualizar el stock: ");
        String id = sc.nextLine(); 
        
        Producto producto = inventario.buscarProductoPorId(id); 
        if (producto != null) {
            System.out.print("Nueva cantidad: ");
            int nuevaCantidad = sc.nextInt();     
            stockApp.actualizarStock(producto, nuevaCantidad);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}