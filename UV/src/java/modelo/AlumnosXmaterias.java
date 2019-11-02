package modelo;

import controlador.GestorAlumnos;
import java.util.ArrayList;


public class AlumnosXmaterias {
    
    private Materia materia;
    private ArrayList<Alumno> vecAlumnos;

    public AlumnosXmaterias() {
        materia=new Materia();
        vecAlumnos=new ArrayList<Alumno>();     
                
    }
   public void llenarVecAlumons()
   {
       GestorAlumnos ga=new GestorAlumnos();
       vecAlumnos=ga.listarAlumnosXmateria(materia);
   }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    public ArrayList<Alumno> getVecAlumnos() {
        return vecAlumnos;
    }
    
}
