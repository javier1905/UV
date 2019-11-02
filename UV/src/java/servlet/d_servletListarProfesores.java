package servlet;

import controlador.GestorProfesores;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "d_servletListarProfesores", urlPatterns = {"/d_servletListarProfesores"})
public class d_servletListarProfesores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorProfesores gp=new GestorProfesores();
        request.setAttribute("vecProfesores", gp.listarProfesores());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/f_listarProfesores.jsp");
        rd.forward(request, response);   
   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorProfesores gp=new GestorProfesores();
        int legajoProfesorAeliminar=Integer.parseInt(request.getParameter("txt_idEliminar"));
        gp.eliminarProfesor(legajoProfesorAeliminar);
        request.setAttribute("vecProfesores", gp.listarProfesores());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/f_listarProfesores.jsp");
        rd.forward(request, response);         
    }


}
