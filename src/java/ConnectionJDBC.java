/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.org.mozilla.javascript.internal.Token;
/**
 *
 * @author JoanMarc
 */
public class ConnectionJDBC {
    public void connect(){
        Connection connection = null;
        try{
            
            Statement statement;
            try {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientServer");
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ISDCM;user=isdcm;password=isdcm");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
                statement = connection.createStatement();
                statement.setQueryTimeout(30);
                statement.executeUpdate("insert into users values('JoanMarc','Capell','joanmarc@gmail.com','joanmarc','123456')");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }finally{
            try{
                if(connection!=null)
                    connection.close();
                
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            
        }
    }
    
    
}
