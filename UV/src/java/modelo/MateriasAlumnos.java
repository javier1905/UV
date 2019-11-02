package modelo;

import controlador.GestorAlumnos;
import controlador.GestorMaterias;
import java.util.ArrayList;

public class MateriasAlumnos {

    private ArrayList<Alumno> vecAlumnos;
    private ArrayList<Materia> vecMaterias;
    private Inscripcion inscripcion;
    
    public MateriasAlumnos() {
        GestorAlumnos ga=new GestorAlumnos();
        GestorMaterias gm=new GestorMaterias();
        
        vecAlumnos=new ArrayList<>();
        vecAlumnos=ga.listarAlumnos();
        
        vecMaterias=new ArrayList<>();
        vecMaterias=gm.listarMaterias();
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
    
    
    
    public ArrayList<Alumno> getVecAlumnos() {
        return vecAlumnos;
    }

    public ArrayList<Materia> getVecMaterias() {
        return vecMaterias;
    }   
}
