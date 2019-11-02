package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.Part;
import modelo.Recurso;


public class GestorRecursos {

    Conexion con;
    
    public GestorRecursos() {
        con=Conexion.getInstance();
    }
    public int insertarRecurso(Recurso r ,Part p)
    {
        int row=0;
        try {
      
        con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("insert into recurso values (?,?,?,?,?,?,1)");
        ps.setString(1, r.getTitulo());
        ps.setString(2, r.getDetalle());
        ps.setString(3, r.getFormato());       
        ps.setBinaryStream(4, p.getInputStream(),(int) p.getSize());
        ps.setBoolean(5, r.getPub_priv());
        ps.setInt(6, r.getMateria().getId());        
        row= ps.executeUpdate();
        con.desconectar(); 
            
        } 
        catch (IOException ex) { } 
        catch(SQLException e){}
        return row;
    }
    
}
