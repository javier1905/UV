package controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.Part;
import modelo.Materia;
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
        ps.setString(4, "ver url");
        ps.setBoolean(5, r.getPub_priv());
        ps.setInt(6, r.getMateria().getId());        
        row= ps.executeUpdate();
        con.desconectar(); 
            
        }       
        catch(SQLException e){}
        return row;
    }
    
    public ArrayList<Recurso> listaRecursosMasCantidadDescarga() 
    {
        ArrayList<Recurso> vec=new ArrayList<Recurso>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select r.id, r.titulo, r.formato, m.id, m.nombre as materia, "
                   + "count(d.id) as cantidadDescargas "
                   + "from descarga d "
                   + "inner join recurso r on d.id_recurso=r.id "
                   + "inner join materia m on r.id_materia=m.id "
                   + "where r.pub_priv=0 and d.estado=1 "
                   + "group by r.id, r.titulo, r.formato, m.id, m.nombre");
           while(r.next())
           {
               Recurso re=new Recurso();
               re.setId(r.getInt(1));
               re.setTitulo(r.getString(2));
               re.setFormato(r.getString(3));
               re.getMateria().setId(r.getInt(4));
               re.getMateria().setNombre(r.getString(5));
               re.setCantDescargas(r.getInt(6));
               
               vec.add(re);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public ArrayList<Recurso> listaRecursosPUBLICOPorMateria(Materia m) 
    {
        ArrayList<Recurso> vec=new ArrayList<Recurso>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select r.id, r.titulo, r.detalle, r.formato, r.archivo, "
                   + "pub_priv, m.id, m.nombre "                  
                   + "from recurso r "                 
                   + "inner join materia m on r.id_materia=m.id "
                   + "where r.pub_priv=0 and r.estado=1 and r.id_materia="+m.getId());               
           while(r.next())
           {
               Recurso re=new Recurso();
               re.setId(r.getInt(1));
               re.setTitulo(r.getString(2));
               re.setDetalle(r.getString(3));
               re.setFormato(r.getString(4));
               re.setArchivo(r.getString(5));
               re.setPub_priv(r.getBoolean(6));
               re.getMateria().setId(r.getInt(7));
               re.getMateria().setNombre(r.getString(8));             
               
               vec.add(re);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
    public ArrayList<Recurso> listaRecursosPRIVADOSPorMateria(Materia m) 
    {
        ArrayList<Recurso> vec=new ArrayList<Recurso>();
        
        try
        {   
           con.conectar();
           Statement st=con.getConnection().createStatement();
           ResultSet r=st.executeQuery("select r.id, r.titulo, r.detalle, r.formato, r.archivo, "
                   + "pub_priv, m.id, m.nombre "                  
                   + "from recurso r "                 
                   + "inner join materia m on r.id_materia=m.id "
                   + "where r.pub_priv=1 and r.estado=1 and r.id_materia="+m.getId());               
           while(r.next())
           {
               Recurso re=new Recurso();
               re.setId(r.getInt(1));
               re.setTitulo(r.getString(2));
               re.setDetalle(r.getString(3));
               re.setFormato(r.getString(4));
               re.setArchivo(r.getString(5));
               re.setPub_priv(r.getBoolean(6));
               re.getMateria().setId(r.getInt(7));
               re.getMateria().setNombre(r.getString(8));             
               
               vec.add(re);
           }
           r.close();
           con.desconectar();
        }catch(SQLException e)  { System.out.println("Error de conexion");  }
        
        return vec;
    }
    
}
