package servlet;

import controlador.GestorAlumnosXmaterias;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;


@WebServlet(name = "f_servletListarAlumnosxMateria", urlPatterns = {"/f_servletListarAlumnosxMateria"})
public class f_servletListarAlumnosxMateria extends HttpServlet {
    
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
            GestorAlumnosXmaterias gestorAxMateias=new GestorAlumnosXmaterias();
            request.setAttribute("vecAlumnoXmaterias", gestorAxMateias.listarMateriasConInscripciones());
            RequestDispatcher rd=request.getRequestDispatcher("/k_listaAlumnosXmateria.jsp");
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
      
    }


}
