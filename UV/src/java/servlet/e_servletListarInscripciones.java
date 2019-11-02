package servlet;

import controlador.GestorInscripciones;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "e_servletListarInscripciones", urlPatterns = {"/e_servletListarInscripciones"})
public class e_servletListarInscripciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorInscripciones gi=new GestorInscripciones();
        request.setAttribute("vecInscripciones", gi.listarInscripciones());
        RequestDispatcher rd=request.getRequestDispatcher("/i_listarInscripciones.jsp");
        rd.forward(request, response);
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


}
