package model;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private String idPedido;
    private String idCliente;
    private List<CarritoItem> items;
    private LocalDate fecha;
    private double total;
    private EstadoPedido estado;

    // Constructor
    public Pedido() {
    }

    public Pedido(String idCliente, List<CarritoItem> items) {
    this.idCliente = idCliente;
    this.items = items;
    this.fecha = LocalDate.now(); 
    this.total = calcularTotal(); 
    this.estado = EstadoPedido.PROCESANDO; 
    this.idPedido = generarIdPedido(); 
}

private String generarIdPedido() {
    return "PED-" + System.currentTimeMillis();
}
    // Getters y setters
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public List<CarritoItem> getItems() {
        return items;
    }

    public void setItems(List<CarritoItem> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    //METODOS
    public double calcularTotal() {
        double total = 0;
        for (CarritoItem item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public boolean realizarPedido(String respuesta) {
        if(respuesta.equals("s")){
            cambiarEstado(EstadoPedido.PAGADO);
            return true;
        } else{
            cambiarEstado(EstadoPedido.CANCELADO);
            return false;
        }
    }

    public void cambiarEstado(EstadoPedido estado) {
        setEstado(estado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido: ").append(idPedido).append("\n")
          .append("Cliente: ").append(idCliente).append("\n")
          .append("Estado: ").append(estado).append("\n")
          .append("Total: ").append(total).append("\n")
          .append("Productos: \n");
        for (CarritoItem item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
