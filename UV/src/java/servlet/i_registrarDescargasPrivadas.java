package servlet;

import controlador.GestorAlumnos;
import controlador.GestorDescargas;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Usuario;


@WebServlet(name = "i_registrarDescargasPrivadas", urlPatterns = {"/i_registrarDescargasPrivadas"})
public class i_registrarDescargasPrivadas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String patch=request.getParameter("url");
        int id_recurso=Integer.parseInt(request.getParameter("idRecurso"));
        GestorDescargas gd=new GestorDescargas();
        Alumno a=new Alumno();
        GestorAlumnos ga=new GestorAlumnos();
        Usuario u=(Usuario)request.getSession().getAttribute("usuario");        
        
        if(u.getTipoUsuario().equalsIgnoreCase("alumno"))
        {
            a=ga.obtenerAlumno(u.getUsuario());
            gd.cargarDescargaPRIVADA(id_recurso,a.getNombre(),a.getApellido());
        }else if(u.getTipoUsuario().equalsIgnoreCase("admin"))
        {
            gd.cargarDescargaPRIVADA(id_recurso,"admin","admin");
        }
        
        
        
      
         
        downloadFile(response,this.getServletContext().getRealPath(patch));
      
    }
    
    protected void downloadFile(HttpServletResponse response, String filePath)
    throws ServletException, IOException {

        File fileToDownload = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(fileToDownload);

        ServletOutputStream out = response.getOutputStream();   
        String mimeType =  new MimetypesFileTypeMap().getContentType(filePath); 

        response.setContentType(mimeType); 
        response.setContentLength(fileInputStream.available());
        response.setHeader( "Content-Disposition", "attachment; filename=\""
          + fileToDownload.getName() + "\"" );

        int c;
        while((c=fileInputStream.read()) != -1){
         out.write(c);
        }
        out.flush();
        out.close();
        fileInputStream.close();
       }

}
