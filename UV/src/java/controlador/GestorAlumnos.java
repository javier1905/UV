package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Materia;

public class GestorAlumnos {
        Conexion con;

    public GestorAlumnos() {
      con=Conexion.getInstance();
    }
        public void cargarAlumno(Alumno a)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertaAlumno ?,?,?");
        ps.setString(1, a.getNombre());
        ps.setString(2, a.getApellido());
        ps.setInt(3, a.getDni());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    public ArrayList<Alumno> listarAlumnos() 
    {
        ArrayList<Alumno> vec=new ArrayList<Alumno>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select * from alumno where estado=1");
           while(r.next())
           {
               Alumno a=new Alumno();
               a.setLegajo(r.getInt(1));
               a.setNombre(r.getString(2));
               a.setApellido(r.getString(3));
               a.setDni(r.getInt(4));
               vec.add(a);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public ArrayList<Alumno> listarAlumnosXmateria(Materia m) 
    {
        ArrayList<Alumno> vec=new ArrayList<Alumno>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select a.legajo, a.nombre, a.apellido, a.dni "
                   + "from alumno a "
                   + "inner join inscripcion i on a.legajo=i.id_alumno "
                   + "where i.estado=1 and i.id_materia="+m.getId());
           while(r.next())
           {
               Alumno a=new Alumno();
               a.setLegajo(r.getInt(1));
               a.setNombre(r.getString(2));
               a.setApellido(r.getString(3));
               a.setDni(r.getInt(4));
               vec.add(a);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public void eliminarAlumno(int idAlumno)
    {
        try{
           con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update alumno set estado=0 where legajo=?");
           ps.setInt(1, idAlumno);
           ps.executeUpdate();
           con.desconectar();
        }catch(SQLException ex) { }
    }
    public void actualizarAlumno(Alumno a)  
    {
        try
        {           
            con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update  alumno set nombre=?, apellido=?, dni=? where legajo=? ");
           ps.setString(1, a.getNombre());
           ps.setString(2, a.getApellido());
           ps.setInt(3, a.getDni());
           ps.setInt(4, a.getLegajo());
           
           ps.executeUpdate();
           con.desconectar();
        }
        catch(SQLException ex){ }
    }
    
    public Alumno obtenerAlumno(int id)
    {
        Alumno a=new Alumno();
        try
        {
            con.conectar();
        Statement s=con.getConnection().createStatement();
        ResultSet r=s.executeQuery("SELECT top 1 legajo, nombre, apellido, dni from alumno where estado=1 and legajo="+id);
            while(r.next())
            {                
                a.setLegajo(r.getInt("legajo"));
                a.setNombre(r.getString("nombre"));
                a.setApellido(r.getString("apellido"));
                a.setDni(r.getInt("dni"));
            }
        r.close();
        con.desconectar();
        }
        catch(SQLException ex){ }
        return a;
    }

}
