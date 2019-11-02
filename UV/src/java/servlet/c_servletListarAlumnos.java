package servlet;

import controlador.GestorAlumnos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;


@WebServlet(name = "c_servletListarAlumnos", urlPatterns = {"/c_servletListarAlumnos"})
public class c_servletListarAlumnos extends HttpServlet {
    
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
            GestorAlumnos ga=new GestorAlumnos();
            request.setAttribute("vecAlumnos", ga.listarAlumnos());
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/d_listarAlumnos.jsp");
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
       int legajoAlumno=Integer.parseInt(request.getParameter("txt_idEliminar"));
       GestorAlumnos ga=new GestorAlumnos();
       ga.eliminarAlumno(legajoAlumno);
       request.setAttribute("vecAlumnos", ga.listarAlumnos());
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/d_listarAlumnos.jsp");
       rd.forward(request, response); 
    }


}
