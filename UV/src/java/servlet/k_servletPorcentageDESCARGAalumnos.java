package servlet;

import controlador.GestorAlumnos;
import controlador.GestorDescargas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Descarga;


@WebServlet(name = "k_servletPorcentageDESCARGAalumnos", urlPatterns = {"/k_servletPorcentageDESCARGAalumnos"})
public class k_servletPorcentageDESCARGAalumnos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int idAlumno= Integer.parseInt(request.getParameter("dat"));
       
       Alumno a=new Alumno();
       GestorAlumnos ga=new GestorAlumnos();
       a=ga.obtenerAlumno(idAlumno);
       GestorDescargas gd=new GestorDescargas();
       ArrayList<Descarga> vecDescargas=new ArrayList<Descarga>();
       vecDescargas=gd.listadoDescargasPorAlumnoYmaterias(a.getNombre(), a.getApellido());
       request.setAttribute("vecDescargas", vecDescargas);
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/o_listaDescargasPorAlumno.jsp");
       rd.forward(request, response);  
       
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }


}
