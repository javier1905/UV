package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Materia;

public class GestorMaterias {
    
    Conexion con;

    public GestorMaterias() {
      con=Conexion.getInstance();
    }
    public void cargarMateria(Materia m)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("insert into materia values (?,1)");
        ps.setString(1, m.getNombre());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    public ArrayList<Materia> listarMaterias() 
    {
        ArrayList<Materia> vec=new ArrayList<Materia>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select * from materia where estado=1");
           while(r.next())
           {
               Materia m=new Materia();
               m.setId(r.getInt(1));
               m.setNombre(r.getString(2));
               vec.add(m);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public ArrayList<Materia> listarMateriasConInscripciones() 
    {
        ArrayList<Materia> vec=new ArrayList<Materia>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select distinct m.id, m.nombre from inscripcion i "
                   + "inner join materia m on  i.id_materia=m.id "
                   + "where i.estado=1");
           while(r.next())
           {
               Materia m=new Materia();
               m.setId(r.getInt(1));
               m.setNombre(r.getString(2));
               vec.add(m);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public ArrayList<Materia> listarMateriasConRecursosaPUBLICOS() 
    {
        ArrayList<Materia> vec=new ArrayList<Materia>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select distinct m.id, m.nombre "
                   + "from recurso r "
                   + "inner join materia m on r.id_materia=m.id "
                   + "where r.estado=1  and r.pub_priv=0");
           while(r.next())
           {
               Materia m=new Materia();
               m.setId(r.getInt(1));
               m.setNombre(r.getString(2));
               vec.add(m);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    public ArrayList<Materia> listarMateriasxAlumnoINSCRIPTO(Alumno a) 
    {
        ArrayList<Materia> vec=new ArrayList<Materia>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select distinct m.id, m.nombre "
                   + "from inscripcion i "
                   + "inner join materia m on i.id_materia=m.id "
                   + "inner join alumno a on i.id_alumno=a.legajo "
                   + "where i.estado=1 and i.id_alumno="+a.getLegajo());
           while(r.next())
           {
               Materia m=new Materia();
               m.setId(r.getInt(1));
               m.setNombre(r.getString(2));
               vec.add(m);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public void eliminarMateria(int idMateria)
    {
        try{
           con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update materia set estado=0 where id=?");
           ps.setInt(1, idMateria);
           ps.executeUpdate();
           con.desconectar();
        }catch(SQLException ex) { }
    }
    public void actualizarMateria(Materia m)  
    {
        try
        {           
            con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update  materia set nombre=? where id=? ");
           ps.setString(1, m.getNombre()); 
           ps.setInt(2, m.getId());
           
           ps.executeUpdate();
           con.desconectar();
        }
        catch(SQLException ex){ }
    }
    
    public Materia obtenerMateria(int id)
    {
        Materia m=new Materia();
        try
        {
            con.conectar();
        Statement s=con.getConnection().createStatement();
        ResultSet r=s.executeQuery("SELECT top 1 id, nombre from materia where estado=1 and id="+id);
            while(r.next())
            {                
                m.setId(r.getInt("id"));
                m.setNombre(r.getString("nombre"));                                     
            }
        r.close();
        con.desconectar();
        }
        catch(SQLException ex){ }
        return m;
    }
        
    
}
