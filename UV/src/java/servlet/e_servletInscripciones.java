package servlet;

import controlador.GestorInscripciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.MateriasAlumnos;

@WebServlet(name = "e_servletInscripciones", urlPatterns = {"/e_servletInscripciones"})
public class e_servletInscripciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     MateriasAlumnos ma=new MateriasAlumnos();
     GestorInscripciones gi=new GestorInscripciones();
     
     try{ma.setInscripcion(gi.obtenerInscripcion(Integer.parseInt(request.getParameter("dat"))));}
     catch(Exception e) { }
     request.setAttribute("materiaAlumno", ma);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/j_fomrInscipcion.jsp");
        rq.forward(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
