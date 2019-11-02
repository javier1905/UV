package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Inscripcion;

public class GestorInscripciones {
        
    Conexion con;

    public GestorInscripciones() {
      con=Conexion.getInstance();
    }
        public void cargarInscripcion(Inscripcion i)
    {
        try
        {
         con.conectar();
        PreparedStatement ps=con.getConnection().prepareStatement("exec pa_insertaInscripcion ?,?");
        ps.setInt(1, i.getAlumno().getLegajo());
        ps.setInt(2, i.getMateria().getId());
        ps.executeUpdate();
        con.desconectar();
        }catch(SQLException e){}
    }
    public ArrayList<Inscripcion> listarInscripciones() 
    {
        ArrayList<Inscripcion> vec=new ArrayList<Inscripcion>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select i.id as idInscripcion , a.legajo as legAlumno , a.nombre, a.apellido, "
                   + "a.dni,m.id as idMateria, m.nombre as nomMateria "
                   + "from inscripcion i  inner join alumno a on i.id_alumno=a.legajo "
                   + "inner join materia m on i.id_materia=m.id "
                   + "where i.estado=1");
           while(r.next())
           {
               Inscripcion i=new Inscripcion();
               i.setId(r.getInt(1));
               i.getAlumno().setLegajo(r.getInt(2));
               i.getAlumno().setNombre(r.getString(3));
               i.getAlumno().setApellido(r.getString(4));
               i.getAlumno().setDni(r.getInt(5));
               i.getMateria().setId(r.getInt(6));
               i.getMateria().setNombre(r.getString(7));
               
               vec.add(i);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    public void eliminarInscripcion(int idInscripcion)
    {
        try{
           con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update inscripcion set estado=0 where id=?");
           ps.setInt(1, idInscripcion);
           ps.executeUpdate();
           con.desconectar();
        }catch(SQLException ex) { }
    }
    public void actualizarInscripcion(Inscripcion i)  
    {
        try
        {           
            con.conectar();
           PreparedStatement ps=con.getConnection().prepareStatement("update  inscripcion set id_alumno=?, id_materia=? where id=? ");
           ps.setInt(1, i.getAlumno().getLegajo());
           ps.setInt(2, i.getMateria().getId()); 
           ps.setInt(3, i.getId());
           
           ps.executeUpdate();
           con.desconectar();
        }
        catch(SQLException ex){ }
    }
    
    public Inscripcion obtenerInscripcion(int id)
    {
        Inscripcion i=new Inscripcion();
        try
        {
            con.conectar();
        Statement s=con.getConnection().createStatement();
        ResultSet r=s.executeQuery("select top 1 i.id as idInscripcion , a.legajo as legAlumno , "
                + "a.nombre, a.apellido, a.dni,m.id as idMateria, m.nombre as nomMateria "
                + "from inscripcion i  "
                + "inner join alumno a on i.id_alumno=a.legajo "
                + "inner join materia m on i.id_materia=m.id "
                + "where i.estado=1 and i.id="+id);
            while(r.next())
            {                
               i.setId(r.getInt(1));
               i.getAlumno().setLegajo(r.getInt(2));
               i.getAlumno().setNombre(r.getString(3));
               i.getAlumno().setApellido(r.getString(4));
               i.getAlumno().setDni(r.getInt(5));
               i.getMateria().setId(r.getInt(6));
               i.getMateria().setNombre(r.getString(7));
            }
        r.close();
        con.desconectar();
        }
        catch(SQLException ex){ }
        return i;
    }
}
