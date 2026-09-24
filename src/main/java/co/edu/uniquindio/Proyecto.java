package co.edu.uniquindio;

import java.util.Arrays;

public class Proyecto {

    private String codigo;
    private String fechaSolicitud;
    private String fechaInicio;
    private String fechaEntrega;
    private String estado;
    private String metodoPago;
    private double valorTotal;
    private Cliente cliente;
    private Desarrollador[] desarrolladoresAsignados;
    private ServicioAdicional[] serviciosContratados;



    public Proyecto(String codigo, String fechaSolicitud,
                    String fechaInicio, String fechaEntrega,
                    String estado, String metodoPago, Cliente cliente) {
        this.codigo = codigo;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.desarrolladoresAsignados = new Desarrollador[5];
        this.serviciosContratados = new ServicioAdicional[5];
        this.valorTotal = 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Desarrollador[] getDesarrolladoresAsignados() {
        return desarrolladoresAsignados;
    }

    public void setDesarrolladoresAsignados(Desarrollador[] desarrolladoresAsignados) {
        this.desarrolladoresAsignados = desarrolladoresAsignados;
    }

    public ServicioAdicional[] getServiciosContratados() {
        return serviciosContratados;
    }

    public void setServiciosContratados(ServicioAdicional[] serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }


    

    @Override
    public String toString() {
        return "Proyecto{" +
                "codigo='" + codigo + '\'' +
                ", fechaSolicitud='" + fechaSolicitud + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", desarrolladoresAsignados=" + Arrays.toString(desarrolladoresAsignados) +
                ", serviciosContratados=" + Arrays.toString(serviciosContratados) +
                '}';
    }
}
