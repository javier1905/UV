package servlet;

import controlador.GestorProfesores;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;


@WebServlet(name = "d_servletListarProfesores", urlPatterns = {"/d_servletListarProfesores"})
public class d_servletListarProfesores extends HttpServlet {
    
    private boolean verificarLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        if(request.getSession().getAttribute("usuario")==null)
        { 
          String direccion=request.getServletPath();           
          response.sendRedirect("LoginServlet?patch=/UV"+direccion);
          return false;
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        if(!verificarLogin(request,response)) { return; }
        String admin="";
        Usuario u=new Usuario();
       
        try
        {  
            u=(Usuario)request.getSession().getAttribute("usuario");
            admin=u.getTipoUsuario();
        }catch(Exception ex){}
        
        if(admin.equalsIgnoreCase("admin"))
        {
            GestorProfesores gp=new GestorProfesores();
            request.setAttribute("vecProfesores", gp.listarProfesores());
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/f_listarProfesores.jsp");
            rd.forward(request, response);  
        }
        else
        {            
            response.sendRedirect(""); 
        }
  
   
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
