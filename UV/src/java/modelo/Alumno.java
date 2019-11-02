package modelo;


public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private int dni;
    private boolean estado;

    public Alumno() {
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Alumno{" + "legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", estado=" + estado + '}';
    }
    
    
    
    
}
