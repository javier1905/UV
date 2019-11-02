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


@WebServlet(name = "b_servletMaterias", urlPatterns = {"/b_servletMaterias"})
public class b_servletMaterias extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            GestorMaterias gm=new GestorMaterias();
            Materia m=new Materia();            
        try{ m=gm.obtenerMateria(Integer.parseInt(request.getParameter("dat"))); }
        catch(Exception es) { } 
        request.setAttribute("materiaAeditar", m);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/c_formMateria.jsp");
        rq.forward(request, response);       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Materia m=new Materia();
        GestorMaterias gm=new GestorMaterias();
        m.setId(Integer.parseInt(request.getParameter("txt_id")));
        m.setNombre(request.getParameter("txt_nombre"));
        if(m.getId()!=0)
        {
            gm.actualizarMateria(m);
        }else
        {
            gm.cargarMateria(m);
        }
        request.setAttribute("vecMaterias", gm.listarMaterias());
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/b_listarMaterias.jsp");
        rd.forward(request, response);  
                
    }


}
