package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Profesor;

public class GestorProfesores {
            Conexion con;

    public GestorProfesores() {
      con=Conexion.getInstance();
    }
        public void cargarProfesor(Profesor p)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertaProfesor ?,?,?");
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getApellido());
        ps.setInt(3, p.getDni());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    public ArrayList<Profesor> listarProfesores() 
    {
        ArrayList<Profesor> vec=new ArrayList<Profesor>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select * from profesor where estado=1");
           while(r.next())
           {
               Profesor p=new Profesor();
               p.setLegajo(r.getInt(1));
               p.setNombre(r.getString(2));
               p.setApellido(r.getString(3));
               p.setDni(r.getInt(4));
               vec.add(p);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    public void eliminarProfesor(int idProfesor)
    {
        try{
           con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update profesor set estado=0 where legajo=?");
           ps.setInt(1, idProfesor);
           ps.executeUpdate();
           con.desconectar();
        }catch(SQLException ex) { }
    }
    public void actualizarProfesor(Profesor p)  
    {
        try
        {           
            con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update  profesor set nombre=?, apellido=?, dni=? where legajo=? ");
           ps.setString(1, p.getNombre());
           ps.setString(2, p.getApellido());
           ps.setInt(3, p.getDni());
           ps.setInt(4, p.getLegajo());
           
           ps.executeUpdate();
           con.desconectar();
        }
        catch(SQLException ex){ }
    }
    
    public Profesor obtenerProfesor(int id)
    {
        Profesor p=new Profesor();
        try
        {
            con.conectar();
        Statement s=con.getConnection().createStatement();
        ResultSet r=s.executeQuery("SELECT top 1 legajo, nombre, apellido, dni from profesor where estado=1 and legajo="+id);
            while(r.next())
            {                
                p.setLegajo(r.getInt("legajo"));
                p.setNombre(r.getString("nombre"));
                p.setApellido(r.getString("apellido"));
                p.setDni(r.getInt("dni"));
            }
        r.close();
        con.desconectar();
        }
        catch(SQLException ex){ }
        return p;
    }
    
}
