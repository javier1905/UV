
package servlet;

import controlador.GestorDescargas;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "h_registrarDescargasPublicas", urlPatterns = {"/h_registrarDescargasPublicas"})
public class h_registrarDescargasPublicas extends HttpServlet {
    
    
private static final long serialVersionUID = 4440011247408877539L;

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
        gd.cargarDescargaPUBLICA(id_recurso);
         
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



