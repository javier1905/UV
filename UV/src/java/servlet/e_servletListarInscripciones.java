package servlet;

import controlador.GestorInscripciones;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;


@WebServlet(name = "e_servletListarInscripciones", urlPatterns = {"/e_servletListarInscripciones"})
public class e_servletListarInscripciones extends HttpServlet {

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
            GestorInscripciones gi=new GestorInscripciones();
            request.setAttribute("vecInscripciones", gi.listarInscripciones());
            RequestDispatcher rd=request.getRequestDispatcher("/i_listarInscripciones.jsp");
            rd.forward(request, response);
        }else
        {
          response.sendRedirect(""); 
        }
     
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idInscripcionAelimnar=Integer.parseInt(request.getParameter("txt_idEliminar"));
        GestorInscripciones gi=new GestorInscripciones();
        gi.eliminarInscripcion(idInscripcionAelimnar);      
        request.setAttribute("vecInscripciones", gi.listarInscripciones());
        RequestDispatcher rd=request.getRequestDispatcher("/i_listarInscripciones.jsp");
        rd.forward(request, response);
        
      
    }


}
