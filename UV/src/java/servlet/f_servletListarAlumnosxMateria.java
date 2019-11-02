package servlet;

import controlador.GestorAlumnosXmaterias;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "f_servletListarAlumnosxMateria", urlPatterns = {"/f_servletListarAlumnosxMateria"})
public class f_servletListarAlumnosxMateria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorAlumnosXmaterias gestorAxMateias=new GestorAlumnosXmaterias();
        request.setAttribute("vecAlumnoXmaterias", gestorAxMateias.listarMateriasConInscripciones());
        RequestDispatcher rd=request.getRequestDispatcher("/k_listaAlumnosXmateria.jsp");
        rd.forward(request, response);
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


}
