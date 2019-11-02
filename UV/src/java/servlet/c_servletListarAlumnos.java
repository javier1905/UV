package servlet;

import controlador.GestorAlumnos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "c_servletListarAlumnos", urlPatterns = {"/c_servletListarAlumnos"})
public class c_servletListarAlumnos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnos ga=new GestorAlumnos();
        request.setAttribute("vecAlumnos", ga.listarAlumnos());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/d_listarAlumnos.jsp");
        rd.forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int legajoAlumno=Integer.parseInt(request.getParameter("txt_idEliminar"));
       GestorAlumnos ga=new GestorAlumnos();
       ga.eliminarAlumno(legajoAlumno);
       request.setAttribute("vecAlumnos", ga.listarAlumnos());
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/d_listarAlumnos.jsp");
       rd.forward(request, response); 
    }


}
