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
    
        public void cargarDescargaPRIVADA(int idRecurso ,String nombre_alumno, String apellido_alumno)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertarDescargaPrivada ?,?,?");       
        ps.setInt(1,idRecurso);
        ps.setString(2, nombre_alumno);
        ps.setString(3, apellido_alumno);
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    
}
