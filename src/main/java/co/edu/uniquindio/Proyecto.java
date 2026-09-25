package co.edu.uniquindio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {this.codigo = codigo;}

    public String getFechaSolicitud() {return fechaSolicitud;}

    public void setFechaSolicitud(String fechaSolicitud) {this.fechaSolicitud = fechaSolicitud;}

    public String getFechaInicio() {return fechaInicio;}

    public void setFechaInicio(String fechaInicio) {this.fechaInicio = fechaInicio;}

    public String getFechaEntrega() {return fechaEntrega;}

    public void setFechaEntrega(String fechaEntrega) {this.fechaEntrega = fechaEntrega;}

    public String getMetodoPago() {return metodoPago;}

    public void setMetodoPago(String metodoPago) {this.metodoPago = metodoPago;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public double getValorTotal() {return valorTotal;}

    public void setValorTotal(double valorTotal) {this.valorTotal = valorTotal;}

    public Cliente getCliente() {return cliente;}

    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public Desarrollador[] getDesarrolladoresAsignados() {return desarrolladoresAsignados;}

    public void setDesarrolladoresAsignados(Desarrollador[] desarrolladoresAsignados) {this.desarrolladoresAsignados = desarrolladoresAsignados;}

    public ServicioAdicional[] getServiciosContratados() {return serviciosContratados;}

    public void setServiciosContratados(ServicioAdicional[] serviciosContratados) {this.serviciosContratados = serviciosContratados;}

    public boolean asignarDesarrollador(Desarrollador dev) {
        for (int i = 0; i < desarrolladoresAsignados.length; i++) {
            if (desarrolladoresAsignados[i] == null) {
                desarrolladoresAsignados[i] = dev;
                dev.setEstado("Asignado");
                return true;
            }
        }
        return false;
    }

    public boolean agregarServicio(ServicioAdicional servicio) {
        for (int i = 0; i < serviciosContratados.length; i++) {
            if (serviciosContratados[i] == null) {
                serviciosContratados[i] = servicio;
                return true;
            }
        }
        return false;
    }

    public double calcularValorTotal() {
        long dias = 1;
        try {
            LocalDate inicio = LocalDate.parse(this.fechaInicio);
            LocalDate fin = LocalDate.parse(this.fechaEntrega);
            dias = ChronoUnit.DAYS.between(inicio, fin);
            if (dias <= 0) dias = 1;
        } catch (Exception e) {
            dias = 30;
        }

        double totalDevs = 0.0;
        for (Desarrollador dev : desarrolladoresAsignados) {
            if (dev != null) {
                totalDevs += (dev.getTarifaPorDia() * dias);
            }
        }

        double totalServicios = 0.0;
        for (ServicioAdicional serv : serviciosContratados) {
            if (serv != null) {
                totalServicios += serv.getPrecio();
            }
        }

        double subtotal = totalDevs + totalServicios;



        if (cliente != null && cliente.isEsFrecuente()) {
            subtotal = subtotal * 0.90;
        }

        this.valorTotal = subtotal;
        return this.valorTotal;
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
