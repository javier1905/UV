package servlet;
import controlador.GestorMaterias;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Materia;
import modelo.RecursosMateria;


@WebServlet(name = "h_servletDescargasPublicas", urlPatterns = {"/h_servletDescargasPublicas"})
public class h_servletListarDescargasPublicas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorMaterias gm=new GestorMaterias();
        ArrayList<Materia> vecMateriasConRecursoPublico=new ArrayList<Materia>();
        vecMateriasConRecursoPublico=gm.listarMateriasConRecursosaPUBLICOS();
        
        ArrayList<RecursosMateria> vecRecursosMateria=new ArrayList<RecursosMateria>();
        
        for(Materia m: vecMateriasConRecursoPublico)
        {
            RecursosMateria rm=new RecursosMateria();
            
            rm.setMateria(m);
            rm.llenarVecAlumonsRecursosPUBLICOS();
            vecRecursosMateria.add(rm);
            
        }
        request.setAttribute("vecRecursoMateria", vecRecursosMateria);
        RequestDispatcher rd=request.getRequestDispatcher("/ll_descargasPublicas.jsp");
        rd.forward(request, response);
        
        
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
