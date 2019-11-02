package modelo;

public class Inscripcion {
    
    private int id;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion() {
        alumno=new Alumno();
        materia=new Materia();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "alumno=" + alumno + ", materia=" + materia + '}';
    }
    
    
    
}
