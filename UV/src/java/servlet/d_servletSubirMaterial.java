package servlet;

import controlador.GestorMaterias;
import controlador.GestorRecursos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import modelo.Usuario;

@WebServlet(name = "d_servletDescargas", urlPatterns = {"/d_servletSubirMaterial"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5,
        location = "C:\\Users\\javie\\OneDrive\\Escritorio\\UV02\\UV\\web\\archivos")
public class d_servletSubirMaterial extends HttpServlet {
    
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
        RequestDispatcher rs = request.getRequestDispatcher("h_subirRecurso.jsp");
        rs.include(request, response); 
        }
        else
        {
            response.sendRedirect(""); 

        }
        
       
       
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();   
                
                Recurso r=new Recurso();           
            
                Part p = request.getPart("descarga");               
                
                
                for (Part part : request.getParts()) 
                {
                String fileName = getFileName(part);
                if (!fileName.isEmpty())
                    part.write(fileName);
                }                
                System.out.println(getFileName(p));
                String nombreArchivo=extractFileName(p);
                r.setTitulo(nombreArchivo);               
                r.setFormato(request.getParameter("formato"));
                r.setDetalle(request.getParameter("detalle"));
                r.setPub_priv(Boolean.parseBoolean(request.getParameter("pub_priv")));
                r.getMateria().setId(Integer.parseInt(request.getParameter("idMateria")));
                GestorRecursos gr=new GestorRecursos();
                gr.insertarRecurso(r, p);
                
                GestorMaterias gm=new GestorMaterias();
                request.setAttribute("vecMaterias", gm.listarMaterias());
                response.sendRedirect("d_servletSubirMaterial");                
    }
        private String getFileName(Part part) 
        {
            for (String content : part.getHeader("content-disposition").split(";")) 
            {
                if (content.trim().startsWith("filename")) 
                {
                    return content.substring(content.indexOf("=") + 2, content.length() - 1);
                }
            }
            return "";
        }
        
        //---------------------------------------------------------
    private String extractFileName(Part part) {
         String contentDisp = part.getHeader("content-disposition");
         String[] items = contentDisp.split(";");
         for (String s : items) {
             if (s.trim().startsWith("filename")) {               
                 String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                 clientFileName = clientFileName.replace("\\", "/");
                 int i = clientFileName.lastIndexOf('/');              
                 return clientFileName.substring(i + 1);
             }
         }
         return null;
     }
//     private Long getMaxAttachmentId(Connection conn) throws SQLException 
//     {
//         String sql = "Select max(a.id) from Attachment a";
//         PreparedStatement pstm = conn.prepareStatement(sql);
//         ResultSet rs = pstm.executeQuery();
//         if (rs.next()) {
//             long max = rs.getLong(1);
//             return max;
//         }
//         return 0L;
//     }
//     
//       private void writeToDB(Connection conn, String fileName, InputStream is, String description) throws SQLException 
//       {
//
//             String sql = "Insert into Attachment(Id,File_Name,File_Data,Description) " //
//                     + " values (?,?,?,?) ";
//             PreparedStatement pstm = conn.prepareStatement(sql);
//
//             Long id = this.getMaxAttachmentId(conn) + 1;
//             pstm.setLong(1, id);
//             pstm.setString(2, fileName);
//             pstm.setBlob(3, is);
//             pstm.setString(4, description);
//             pstm.executeUpdate();
//        }
     
}

