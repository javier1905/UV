package modelo;

import java.util.Date;

public class Subida {
    
    private int id;
    private Recurso recurso;
    private Profesor profesor;
    private Date fecha;
    private int cantidadDescargas;
    private int cantidadSubidas;
    private float promedio;

    public Subida() {
        
        profesor=new Profesor();
        recurso=new Recurso();
    }

    public int getId() {
        return id;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public int getCantidadSubidas() {
        return cantidadSubidas;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    public void setCantidadSubidas(int cantidadSubidas) {
        this.cantidadSubidas = cantidadSubidas;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Subida{" + "id=" + id + ", recurso=" + recurso + ", profesor=" + profesor + ", fecha=" + fecha + ", cantidadDescargas=" + cantidadDescargas + ", cantidadSubidas=" + cantidadSubidas + ", promedio=" + promedio + '}';
    }
     
}
