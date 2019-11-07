
package modelo;

import controlador.GestorMaterias;
import controlador.GestorProfesores;
import java.util.ArrayList;

public class MateriaProfesor {
   private ArrayList<Materia> vecMateria;
   private ArrayList<Profesor> vecProfesor;

    public MateriaProfesor() {
        this.vecMateria = new ArrayList<Materia>();
        GestorMaterias gm=new GestorMaterias();
        vecMateria=gm.listarMaterias();
        this.vecProfesor = new ArrayList<Profesor>();
        GestorProfesores gp=new GestorProfesores();
        vecProfesor =gp.listarProfesores();
    }

    public ArrayList<Materia> getVecMateria() {
        return vecMateria;
    }

    public ArrayList<Profesor> getVecProfesor() {
        return vecProfesor;
    }

    public void setVecMateria(ArrayList<Materia> vecMateria) {
        this.vecMateria = vecMateria;
    }

    public void setVecProfesor(ArrayList<Profesor> vecProfesor) {
        this.vecProfesor = vecProfesor;
    }

    

   
    
   
    
    
}
