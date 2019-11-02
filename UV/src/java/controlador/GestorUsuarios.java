package controlador;

import modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestorUsuarios {
    
    Conexion con;

    public GestorUsuarios() {
      con=Conexion.getInstance();
    }
    
    public Usuario buscarUsuario(Usuario uu)
    {
       Usuario u= new Usuario();
       con.conectar();
       int nombre=uu.getUsuario();
       int pas=uu.getPass();
       try
       {
           Statement s=con.getConnection().createStatement();
           ResultSet r=s.executeQuery("select u.id, u.usuario, u.pass, t.descripcion from usuario u inner join TipoUsuario t on u.id_tipoUsuario=t.id where usuario="+nombre+" and pass="+pas);
           while (r.next()) {
               u.setId(r.getInt(1));
               u.setUsuario(r.getInt(2));
               u.setPass(r.getInt(3));
               u.setTipoUsuario(r.getString(4));                            
           }
           r.close();
        con.desconectar();
       }catch(SQLException e) {  }
//       if(u.getUsuario()=="" || u.getUsuario()==null)  {  return null;  }
       if(u.getUsuario()==-1)  {  return null;  }
       else {  return u;  }       
    }
    
}
