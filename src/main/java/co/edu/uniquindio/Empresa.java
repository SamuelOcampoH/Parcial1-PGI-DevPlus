package co.edu.uniquindio;

public class Empresa {

    private String nombre;
    private double nit;
    private int telefono;
    private String paginaWeb;


    public Empresa(String nombre, double nit, int telefono, String paginaWeb) {


        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNit() {
        return nit;
    }

    public void setNit(double nit) {
        this.nit = nit;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", telefono=" + telefono +
                ", paginaWeb='" + paginaWeb + '\'' +
                '}';
    }
}
