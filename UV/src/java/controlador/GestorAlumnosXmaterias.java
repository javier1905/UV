package controlador;

import java.util.ArrayList;
import modelo.AlumnosXmaterias;
import modelo.Materia;


public class GestorAlumnosXmaterias {

    public GestorAlumnosXmaterias() {  }
    
    public ArrayList<AlumnosXmaterias> listarMateriasConInscripciones() 
    {
        ArrayList<AlumnosXmaterias> vec=new ArrayList<AlumnosXmaterias>();
        GestorMaterias gm=new GestorMaterias();
        ArrayList<Materia> listaMateriasInscriptas=new ArrayList<Materia>();
        listaMateriasInscriptas=gm.listarMateriasConInscripciones();
        for(Materia m: listaMateriasInscriptas)
        {
            AlumnosXmaterias aXm=new AlumnosXmaterias();
            aXm.setMateria(m);
            aXm.llenarVecAlumons();
            vec.add(aXm);
        }       
        return vec;
    }
    
}
