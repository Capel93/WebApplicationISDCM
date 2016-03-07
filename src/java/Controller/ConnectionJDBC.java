package Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.User;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.org.mozilla.javascript.internal.Token;
/**
 *
 * @author JoanMarc
 */
public class ConnectionJDBC {

    static Connection connection = null;
    
    public static void connect(){
        
        
            
            
            try {
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ISDCM;user=isdcm;password=isdcm");

                //Statement statement;
                //ResultSet rs;
                //statement = connection.createStatement();
                //statement.setQueryTimeout(30);
                //statement.executeUpdate("insert into users values('admin','admin','admin@gmail.com','admin','admin')");
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        /*finally{
            try{
                if(connection!=null)
                    connection.close();
                
            }catch(SQLException e){
                System.err.println(e.getMessage());
            }
            
        }*/
    }
    
    
    public static boolean exists(String nickName){
        boolean exists = false;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT NICKNAME,NAME FROM users WHERE nickname='"+nickName+"'");
            while(rs.next()){
                if(rs.getString("NICKNAME").equals(nickName)){
                    exists = true;
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return exists;
    }
    
    public static int addUser(User user){
        try {
            Statement statement;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            return statement.executeUpdate("insert into users values("+user.toString()+")");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
