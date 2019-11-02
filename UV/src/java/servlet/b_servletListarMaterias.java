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
import modelo.Usuario;


@WebServlet(name = "b_servletListarMaterias", urlPatterns = {"/b_servletListarMaterias"})
public class b_servletListarMaterias extends HttpServlet {
    
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
            GestorMaterias gm=new GestorMaterias();
            request.setAttribute("vecMaterias", gm.listarMaterias());
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/b_listarMaterias.jsp");
            rd.forward(request, response); 
        }else
        {
            response.sendRedirect("");
        }    
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
