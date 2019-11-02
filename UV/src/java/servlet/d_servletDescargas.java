package servlet;

import controlador.GestorMaterias;
import controlador.GestorRecursos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Recurso;

@WebServlet(name = "d_servletDescargas", urlPatterns = {"/d_servletDescargas"})
@MultipartConfig(maxFileSize = 16177215)
public class d_servletDescargas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorMaterias gm=new GestorMaterias();
        request.setAttribute("vecMaterias", gm.listarMaterias());
        RequestDispatcher rs = request.getRequestDispatcher("h_descargasPrivadas.jsp");
        rs.include(request, response);        
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();   
                
                Recurso r=new Recurso();           
            
                Part p = request.getPart("file_uploaded");
                
//                for (Part part : request.getParts()) 
//                {
//                String fileName = getFileName(part);
//                if (!fileName.isEmpty())
//                    part.write(fileName);
//                }
                System.out.println(getFileName(p));
                r.setTitulo(p.getName());
               
                r.setFormato(p.getContentType());
                r.setDetalle(request.getParameter("detalle"));
                r.setPub_priv(Boolean.parseBoolean(request.getParameter("pub_priv")));
                
                
                GestorRecursos gr=new GestorRecursos();
                gr.insertarRecurso(r, p);
                GestorMaterias gm=new GestorMaterias();
                request.setAttribute("vecMaterias", gm.listarMaterias());
                RequestDispatcher rs = request.getRequestDispatcher("h_descargasPrivadas.jsp");
                rs.include(request, response);              
                
    }
        private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }

}
