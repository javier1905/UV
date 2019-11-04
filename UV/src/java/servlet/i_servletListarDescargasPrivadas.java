package servlet;

import controlador.GestorAlumnos;
import controlador.GestorMaterias;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Materia;
import modelo.RecursosMateria;
import modelo.Usuario;


@WebServlet(name = "i_servletListarDescargasPrivadas", urlPatterns = {"/i_servletListarDescargasPrivadas"})
public class i_servletListarDescargasPrivadas extends HttpServlet {
    
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
        String tipoUsuario="";
        Usuario uu=new Usuario();
       
        try
        {  
            uu=(Usuario)request.getSession().getAttribute("usuario");
            tipoUsuario=uu.getTipoUsuario();
        }catch(Exception ex){}
        
        if(tipoUsuario.equalsIgnoreCase("admin") || tipoUsuario.equalsIgnoreCase("alumno") )
        {
           GestorMaterias gm=new GestorMaterias();
           ArrayList<Materia> vecMateriaInscriptio =new ArrayList<Materia>();
           Alumno a=new Alumno();
           GestorAlumnos ga=new GestorAlumnos();
           int idAlumno=0;
           Usuario u=new Usuario();
           u=(Usuario)request.getSession().getAttribute("usuario");
           idAlumno=u.getUsuario();

           a=ga.obtenerAlumno(idAlumno);
           if(u.getTipoUsuario().equalsIgnoreCase("alumno"))
           {
               vecMateriaInscriptio=gm.listarMateriasxAlumnoINSCRIPTO(a); 
           }else if(u.getTipoUsuario().equalsIgnoreCase("admin"))
           {
               vecMateriaInscriptio=gm.listarMaterias();
           }

           ArrayList<RecursosMateria> vecRecursosMateria=new ArrayList<RecursosMateria>();
           for(Materia m:vecMateriaInscriptio)
           {
               RecursosMateria rm=new RecursosMateria();
               rm.setMateria(m);
               rm.llenarVecAlumonsRecursosPRIVADOS();
               vecRecursosMateria.add(rm);
           }
           request.setAttribute("vecRecursoMateria", vecRecursosMateria);
            RequestDispatcher rd=request.getRequestDispatcher("/m_descargasPrivadas.jsp");
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
