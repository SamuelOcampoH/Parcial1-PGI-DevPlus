package co.edu.uniquindio;

public class Cliente {
    private String nombre;
    private String documento;
    private String telefono;
    private String correo;
    private String pais;
    private boolean esFrecuente;

    public Cliente(String nombre, String documento, String telefono, String correo, String pais, boolean esFrecuente){
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.pais = pais;
        this.esFrecuente = esFrecuente;
    }

}
