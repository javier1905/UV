package servlet;

import controlador.GestorMaterias;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Materia;


@WebServlet(name = "b_servletListarMaterias", urlPatterns = {"/b_servletListarMaterias"})
public class b_servletListarMaterias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorMaterias gm=new GestorMaterias();
        request.setAttribute("vecMaterias", gm.listarMaterias());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/b_listarMaterias.jsp");
        rd.forward(request, response);     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            GestorMaterias gm=new GestorMaterias();
    Materia m=new Materia();
    m.setId(Integer.parseInt(request.getParameter("txt_idEliminar")));
    gm.eliminarMateria(m.getId());
    request.setAttribute("vecMaterias", gm.listarMaterias());
    RequestDispatcher rd=getServletContext().getRequestDispatcher("/b_listarMaterias.jsp");
    rd.forward(request, response);
      
    }


}
