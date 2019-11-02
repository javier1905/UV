package servlet;

import controlador.GestorProfesores;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Profesor;


@WebServlet(name = "d_servletProfesores", urlPatterns = {"/d_servletProfesores"})
public class d_servletProfesores extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorProfesores gp=new GestorProfesores();
        Profesor p=new Profesor();
        try{ p=gp.obtenerProfesor(Integer.parseInt(request.getParameter("dat"))); }
        catch(Exception ex){ }
        request.setAttribute("profesorAeditar", p);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/g_formProfesor.jsp");
        rq.forward(request, response);   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorProfesores gp=new GestorProfesores();
        Profesor p=new Profesor();
        
        p.setLegajo(0);
        try
        {
           p.setLegajo(Integer.parseInt(request.getParameter("txt_id"))); 
        }catch(Exception e){ }
        
        p.setNombre(request.getParameter("txt_nombre"));
        p.setApellido(request.getParameter("txt_apellido"));
        p.setDni(Integer.parseInt(request.getParameter("txt_dni")));
        
        if(p.getLegajo()!=0)
        {
            gp.actualizarProfesor(p);
        }else
        {
            gp.cargarProfesor(p);
        }
        request.setAttribute("vecProfesores", gp.listarProfesores());
        RequestDispatcher rd= request.getRequestDispatcher("/f_listarProfesores.jsp");
        rd.forward(request, response);       
                
   
    }


}
