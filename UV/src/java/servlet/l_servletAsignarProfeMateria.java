
package servlet;

import controlador.GestorMateriaProfesor;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.MateriaProfesor;
import modelo.Usuario;

@WebServlet(name = "l_servletAsignarProfeMateria", urlPatterns = {"/l_servletAsignarProfeMateria"})
public class l_servletAsignarProfeMateria extends HttpServlet {

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
                  MateriaProfesor materiaProfesor=new MateriaProfesor();
       request.setAttribute("materiaProfesor", materiaProfesor);
        RequestDispatcher rq=getServletContext().getRequestDispatcher("/k_formAsignarProfMat.jsp");
        rq.forward(request, response);  
        }else
        {
            response.sendRedirect(""); 
        }
        
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int idProfesor= Integer.parseInt(request.getParameter("idProfesor"));
       int idMateria= Integer.parseInt(request.getParameter("idMateria"));
       GestorMateriaProfesor gm=new GestorMateriaProfesor();
       gm.cargarProfesorAMAteria(idMateria, idProfesor);
              MateriaProfesor materiaProfesor=new MateriaProfesor();
       request.setAttribute("materiaProfesor", materiaProfesor);
       RequestDispatcher rd=getServletContext().getRequestDispatcher("/k_formAsignarProfMat.jsp");
       rd.forward(request, response); 
       
    }


}
