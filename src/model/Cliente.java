package model;

import java.util.Scanner;

public class Cliente {
    Scanner scanner = new Scanner(System.in);

    private String id;           
    private String nombre;      
    private String email;         
    private String direccion; 
    private String telefono; 
    private String password; 

    // Constructores
    public Cliente() {
    }

    public Cliente(String id, String nombre, String email, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //METODOS
    public void registrarse() {
        System.out.println("Registrar nuevo cliente:");
        
        System.out.print("Nombre: ");
        this.nombre = scanner.nextLine();
        
        System.out.print("Email: ");
        this.email = scanner.nextLine();
        
        System.out.print("Dirección: ");
        this.direccion = scanner.nextLine();
        
        System.out.print("Teléfono: ");
        this.telefono = scanner.nextLine();
        
        System.out.print("Ingrese una contraseña: ");
        this.password = scanner.nextLine();
        
        System.out.println("Cliente registrado: " + nombre);
    }

    public boolean iniciarSesion(String email, String passwordIntentada) {
        if (this.email.equals(email)) {
            if (this.password.equals(passwordIntentada)) {
                System.out.println("Cliente logeado con éxito: " + nombre);
                return true;
            } else {
                System.out.println("Contraseña incorrecta.");
                return false;
            }
        } else {
            System.out.println("Email no encontrado.");
            return false;
        }
    }

    public void modificarDatos(String nuevoNombre, String nuevaDireccion, String nuevoTelefono) {
        this.nombre = nuevoNombre;
        this.direccion = nuevaDireccion;
        this.telefono = nuevoTelefono;
        System.out.println("Datos actualizados para el cliente: " + nuevoNombre);
    }

    @Override
    public String toString() {
        return "Cliente{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", email='" + email + '\'' +
               ", direccion='" + direccion + '\'' +
               ", telefono='" + telefono + '\'' +
               '}';
    }
}
