package modelo;

import controlador.GestorRecursos;
import java.util.ArrayList;


public class RecursosMateria {
    
    private Materia materia;
    private ArrayList<Recurso> listaRecursos;

    public RecursosMateria() {
        materia=new Materia();
        listaRecursos=new ArrayList<Recurso>();
    }
    
       public void llenarVecAlumonsRecursosPUBLICOS()
   {
       GestorRecursos ga=new GestorRecursos();
       listaRecursos=ga.listaRecursosPUBLICOPorMateria(materia);
   }
       
   public void llenarVecAlumonsRecursosPRIVADOS()
   {
       GestorRecursos ga=new GestorRecursos();
       listaRecursos=ga.listaRecursosPRIVADOSPorMateria(materia);
   }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public Materia getMateria() {
        return materia;
    }

    public ArrayList<Recurso> getListaRecursos() {
        return listaRecursos;
    }
    
    
}
