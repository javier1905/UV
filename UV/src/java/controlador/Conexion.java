package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion
{
    private static Conexion con;
    private Connection c;
    
    private Conexion( )
    {    
    
    }    
        public static Conexion getInstance()
        {
            if(con == null)
            {
                con =new Conexion();
            }
            return con;
        }
        public void conectar()   
        {
            try
            {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//            c=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-G1I097C:1433;databaseName=UV6","DBjav","belgrano455");
         //   c=DriverManager.getConnection("jdbc:sqlserver://PC2360:1433;databaseName=UV6","emsDB","belgrano455");
 //         c=DriverManager.getConnection("jdbc:sqlserver://pc2360:1433;databaseName=licencias","emsDB","belgrano455");
 c=DriverManager.getConnection("jdbc:sqlserver://PC2360:1433;databaseName=UV7","emsDB","belgrano455");
            }
            catch(SQLException ex)  {   }
            catch(ClassNotFoundException ex) {  }
            catch(InstantiationException ex) {  }
            catch(IllegalAccessException ex) {  }
        }
        public Connection getConnection()
        {
            return c;
        }
        public void desconectar()
        {
            try 
            {
                c.close();
            } 
            catch (SQLException ex)   {   }
        }
}
