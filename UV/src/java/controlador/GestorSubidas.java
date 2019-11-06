
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Materia;
import modelo.Subida;

public class GestorSubidas {
    
        Conexion con;

    public GestorSubidas() {
      con=Conexion.getInstance();
    }
    
    
        public void cargarSubida(Subida s)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertarSubida ?,? ");
        ps.setInt(1,s.getRecurso().getId());
        ps.setInt(1,s.getProfesor().getLegajo());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    
    
        public ArrayList<Subida> listarSubidass() 
    {
        ArrayList<Subida> vec=new ArrayList<Subida>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select p.legajo, p.nombre, p.apellido, "
                   + "p.dni, m.nombre as nombreMateria, "
                   + "count(p.legajo) as cantidadSubidas, "
                   + "sum(dbo.f_cantidadDescargasPorRecurso(s.id_recurso)) as cantidadDescargas, "
                   + "avg(dbo.f_cantidadDescargas(m.id)) as pormedioDescXmateria "
                   + "from profesor p inner join subidas s on s.id_profesor=p.legajo "
                   + "inner join recurso r on s.id_recurso=r.id "
                   + "inner join materiaXprofesor mp on mp.id_profesor=p.legajo "
                   + "inner join materia m on mp.id_materia=m.id where s. estado=1 "
                   + "group by p.legajo, p.nombre, p.apellido, p.dni, m.nombre");
           while(r.next())
           {
               Subida s=new Subida();
               s.getProfesor().setLegajo(r.getInt(1));
               s.getProfesor().setNombre(r.getString(2));
               s.getProfesor().setApellido(r.getString(3));
               s.getProfesor().setDni(r.getInt(4));
               s.getRecurso().getMateria().setNombre(r.getString(5));
               s.setCantidadSubidas(r.getInt(6));
               s.setCantidadDescargas(r.getInt(7));
               s.setPromedio(r.getFloat(8));
               vec.add(s);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
}
