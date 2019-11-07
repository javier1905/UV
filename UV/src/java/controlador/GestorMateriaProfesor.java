package controlador;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Alumno;
import modelo.MateriaProfesor;


public class GestorMateriaProfesor {
    
            Conexion con;

    public GestorMateriaProfesor() {
      con=Conexion.getInstance();
    }
    
       public void cargarProfesorAMAteria(int idMateria, int idProfesor)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("insert into materiaXprofesor values(?,?,1)");
   
        ps.setInt(1,idMateria);
         ps.setInt(2,idProfesor);
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    
}
