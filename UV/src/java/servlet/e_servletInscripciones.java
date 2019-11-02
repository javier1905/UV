package servlet;

import controlador.GestorInscripciones;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Inscripcion;
import modelo.MateriasAlumnos;

@WebServlet(name = "e_servletInscripciones", urlPatterns = {"/e_servletInscripciones"})
public class e_servletInscripciones extends HttpServlet {
    
    int idInscripcion=-1;
    Inscripcion in=new Inscripcion();
    MateriasAlumnos ma=new MateriasAlumnos();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    GestorInscripciones gi=new GestorInscripciones();
    try{   
        idInscripcion=Integer.parseInt(request.getParameter("dat"));
    }catch(Exception ex){}   
     
     if(idInscripcion!=-1)
     {
        in=gi.obtenerInscripcion(idInscripcion);
        ma.setInscripcion(in);
     }           
         request.setAttribute("materiaAlumno", ma);
 
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/j_fomrInscipcion.jsp");
        rq.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Inscripcion insc=new Inscripcion();
        insc.setId(Integer.parseInt(request.getParameter("id")));
        insc.getAlumno().setLegajo(Integer.parseInt(request.getParameter("id_alumno")));
        insc.getMateria().setId(Integer.parseInt(request.getParameter("id_materia")));
        GestorInscripciones gi=new GestorInscripciones();
        
        if(idInscripcion==-1){ gi.cargarInscripcion(insc);}
        else{ gi.actualizarInscripcion(insc);}
        
        request.setAttribute("vecInscripciones", gi.listarInscripciones());
        RequestDispatcher rd=request.getRequestDispatcher("/i_listarInscripciones.jsp");
        rd.forward(request, response);
       
    }


}
