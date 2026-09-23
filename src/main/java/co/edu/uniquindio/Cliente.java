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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;

    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPais() {
        return pais;

    }

    public void setPais(String pais) {
        this.pais = pais;

    }
    public boolean isEsFrecuente() {
        return esFrecuente;
    }
    public void setEsFrecuente(boolean esFrecuente) {
        this.esFrecuente = esFrecuente;

    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + "| Documento: " + documento + " | Tel: "+ telefono + " | Pais" + pais;
    }

}
