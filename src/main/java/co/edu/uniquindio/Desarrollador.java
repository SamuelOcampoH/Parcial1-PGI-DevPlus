package co.edu.uniquindio;

public class Desarrollador {
    private String codigo;
    private String equipoTrabajo;
    private String nivel;
    private int cantMaxProyectos;
    private double tarifaPorDia;
    private String estado;
    private boolean disnponible;


    public Desarrollador(String codigo, String equipoTrabajo, String nivel, int cantMaxProyectos, double tarifaPorDia, String estado, boolean disnponible) {


        this.codigo = codigo;
        this.equipoTrabajo = equipoTrabajo;
        this.nivel = nivel;
        this.cantMaxProyectos = cantMaxProyectos;
        this.tarifaPorDia = tarifaPorDia;
        this.estado = estado;
        this.disnponible = disnponible;

    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getEquipoTrabajo() {
        return equipoTrabajo;
    }
    public void setEquipoTrabajo(String equipoTrabajo) {
        this.equipoTrabajo = equipoTrabajo;
    }
    public String getNivel() {
        return nivel;

    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public int getCantMaxProyectos() {
        return cantMaxProyectos;
    }
    public void setCantMaxProyectos(int cantMaxProyectos) {
        this.cantMaxProyectos = cantMaxProyectos;
    }
    public double getTarifaPorDia() {
        return tarifaPorDia;
    }

    public void setTarifaPorDia(double tarifaPorDia) {
        this.tarifaPorDia = tarifaPorDia;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public boolean isDisponible() {
        return disnponible;

    }
    public void setDisnponible(boolean disnponible) {
        this.disnponible = disnponible;

    }


    @Override
    public String toString() {
        return "Dev [ " + codigo + "]" + nivel + " (" + equipoTrabajo+ ") - Tarifa/dia: $" + " - Estado: " + estado;
    }
}
