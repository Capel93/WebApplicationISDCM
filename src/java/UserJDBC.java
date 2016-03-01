/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*
/**
 *
 * @author JoanMarc
 */
public class UserJDBC {
    public void connect(){
        Connection connection = null;
        try{
            Class.forName(null);
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ISDCM;user=isdcm;password=isdcm");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(null);
        }catch(Exception e){
            
        }
    }
    
    public void disconnect(){
        
    }
}
