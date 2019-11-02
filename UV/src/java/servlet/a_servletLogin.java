package servlet;


import controlador.GestorUsuarios;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

@WebServlet(name = "A_LoginServlet", urlPatterns = {"/LoginServlet"})
public class a_servletLogin extends HttpServlet {

private String url;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        url=request.getParameter("patch");
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/a_login.jsp");
        rd.forward(request, response);    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
      
        Usuario usuarioTemp=new Usuario();
        usuarioTemp.setUsuario(Integer.parseInt(request.getParameter("user")));
        usuarioTemp.setPass(Integer.parseInt(request.getParameter("password")));
        GestorUsuarios gu=new GestorUsuarios();
        Usuario usuarioTemp2=new Usuario();
        usuarioTemp2=gu.buscarUsuario(usuarioTemp);
        if(usuarioTemp2!= null)
        {
            Usuario u=new Usuario();
            u=usuarioTemp2;
            request.getSession().setAttribute("usuario", u);
            if(url==null || url.isEmpty())
            {
                 response.sendRedirect(""); 
            }else
            {
              response.sendRedirect(url);
            }          
        }else
        {
            if(url==null || url.isEmpty())
            {
              response.sendRedirect("LoginServlet");  
            }else
            {
              response.sendRedirect("LoginServlet?patch="+url);  
            }            
        }  
    }
}
