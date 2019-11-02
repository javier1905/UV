package modelo;
import java.util.Date;


public class Descarga {
    private int id;
    private Date  fecha;
    private Alumno alumno;
    private Recurso recurso;
    private int estado;

    public Descarga() {
        alumno=new Alumno();
        recurso=new Recurso();
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public int getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Descarga{" + "id=" + id + ", fecha=" + fecha + ", alumno=" + alumno + ", recurso=" + recurso + ", estado=" + estado + '}';
    }
    
    
    
}
