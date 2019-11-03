package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Alumno;


public class GestorDescargas {
    
    Conexion con;

    public GestorDescargas() {
        con=Conexion.getInstance();
    }
   
            public void cargarDescargaPUBLICA(int idDescarga)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertarDescargaPublica ?");       
        ps.setInt(1,idDescarga);
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    
}
