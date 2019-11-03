package servlet;

import controlador.GestorRecursos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Recurso;
import modelo.Usuario;

@WebServlet(name = "g_servletListarRecursosCantDescargas", urlPatterns = {"/g_servletListarRecursosCantDescargas"})
public class g_servletListarRecursosCantDescargas extends HttpServlet {
    
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
            GestorRecursos gr=new GestorRecursos();
            ArrayList<Recurso> vecRecursosConDescargas=new ArrayList<Recurso>();
            vecRecursosConDescargas= gr.listaRecursosMasCantidadDescarga();
            request.setAttribute("vecRecursoParam",vecRecursosConDescargas );

            RequestDispatcher rd=request.getRequestDispatcher("/l_reporteDescargasRecursos.jsp");
            rd.forward(request, response);  
        }else
        {
            response.sendRedirect("");
        }
        

       
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
