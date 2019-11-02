package servlet;

import controlador.GestorAlumnos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;

@WebServlet(name = "c_servletAlumnos", urlPatterns = {"/c_servletAlumnos"})
public class c_servletAlumnos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnos ga=new GestorAlumnos();
        Alumno a=new Alumno();
        try{ a=ga.obtenerAlumno(Integer.parseInt(request.getParameter("dat"))); }        
        catch(Exception es) { }
        request.setAttribute("alumnoAeditar", a);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/e_formAlumno.jsp");
        rq.forward(request, response); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnos ga=new GestorAlumnos();
        Alumno a=new Alumno();
        a.setLegajo(0);
        a.setLegajo(Integer.parseInt(request.getParameter("txt_id")));
        a.setNombre(request.getParameter("txt_nombre"));
        a.setApellido(request.getParameter("txt_apellido"));
        a.setDni(Integer.parseInt(request.getParameter("txt_dni")));
        if (a.getLegajo()!=0)
        {
            ga.actualizarAlumno(a);
        }else
        {
            ga.cargarAlumno(a);
        }
        request.setAttribute("vecAlumnos", ga.listarAlumnos());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/d_listarAlumnos.jsp");
        rd.forward(request, response); 
    }


}
