package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Alumno;
import modelo.Descarga;
import modelo.Materia;


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

        public ArrayList<Descarga> listadoDescargasPorAlumnoYmaterias(String nombre_alumno, String apellido_alumno) 
    {
        ArrayList<Descarga> vec=new ArrayList<Descarga>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("exec pa_porcenDescargaxMateria '"+nombre_alumno+"' , '"+apellido_alumno+"'");
           while(r.next())
           {
               Descarga d=new Descarga();
               d.setId(r.getInt(1));
               d.setFecha(r.getDate(2));
               d.getRecurso().setTitulo(r.getString(3));
               d.getRecurso().setFormato(r.getString(4));
               d.getRecurso().getMateria().setId(r.getInt(5));
               d.getRecurso().getMateria().setNombre(r.getString(6));
               d.setPorDescarga(r.getDouble(7));
               vec.add(d);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
}
