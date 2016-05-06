package Controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.User;
import Model.Video;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
    public static boolean exists(String nickName, String password){
        boolean exists = false;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT NICKNAME,PASSWORD FROM users WHERE nickname='"+nickName
                    +"' and password='"+password+"'");
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
    
    public static int addVideo(Video video){
        try {
            Statement statement;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            return statement.executeUpdate("insert into videos values("+video.toString()+")");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static int deleteVideo(int id){
        try {
            Statement statement;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            return statement.executeUpdate("delete from videos where id="+id+"");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static ArrayList<Video> getVideos(){
        ArrayList<Video> videos = null;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT * FROM videos ");
            videos = new ArrayList();
            while(rs.next()){
                Video v = new Video();
                v.setId(rs.getInt("ID"));
                v.setTitle(rs.getString("TITLE"));
                v.setAuthor(rs.getString("AUTHOR"));
                v.setCreation_date(rs.getString("CREATION_DATE"));
                v.setDuration(rs.getString("DURATION"));
                v.setViews(rs.getInt("VIEWS"));
                v.setDescription(rs.getString("DESCRIPTION"));
                v.setFormat(rs.getString("FORMAT"));
                v.setUrl(rs.getString("URL"));
                v.setUploader(rs.getString("UPLOADER"));
                videos.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videos;
    }
    
    public static ArrayList<Video> getVideosByTitle(String title){
        ArrayList<Video> videos = null;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT * FROM videos WHERE title='"+title+"'");
            videos = new ArrayList();
            while(rs.next()){
                Video v = new Video();
                v.setId(rs.getInt("ID"));
                v.setTitle(rs.getString("TITLE"));
                v.setAuthor(rs.getString("AUTHOR"));
                v.setCreation_date(rs.getString("CREATION_DATE"));
                v.setDuration(rs.getString("DURATION"));
                v.setViews(rs.getInt("VIEWS"));
                v.setDescription(rs.getString("DESCRIPTION"));
                v.setFormat(rs.getString("FORMAT"));
                v.setUrl(rs.getString("URL"));
                v.setUploader(rs.getString("UPLOADER"));
                videos.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videos;
    }
    
    public static ArrayList<Video> getVideosByAuthor(String author){
        ArrayList<Video> videos = null;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT * FROM videos WHERE author='"+author+"'");
            videos = new ArrayList();
            while(rs.next()){
                Video v = new Video();
                v.setId(rs.getInt("ID"));
                v.setTitle(rs.getString("TITLE"));
                v.setAuthor(rs.getString("AUTHOR"));
                v.setCreation_date(rs.getString("CREATION_DATE"));
                v.setDuration(rs.getString("DURATION"));
                v.setViews(rs.getInt("VIEWS"));
                v.setDescription(rs.getString("DESCRIPTION"));
                v.setFormat(rs.getString("FORMAT"));
                v.setUrl(rs.getString("URL"));
                v.setUploader(rs.getString("UPLOADER"));
                videos.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videos;
        
    }
    
    public static ArrayList<Video> getVideosByYear(int year){
        ArrayList<Video> videos = null;
        
        Date initDate = new Date(year-1900, 0, 1);
        Date finalDate = new Date(year-1900, 11, 31);
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT * FROM videos WHERE creation_date>'"+initDate.toString()+"'"
                    + " and creation_date<'"+finalDate.toString()+"'");
            videos = new ArrayList();
            while(rs.next()){
                Video v = new Video();
                v.setId(rs.getInt("ID"));
                v.setTitle(rs.getString("TITLE"));
                v.setAuthor(rs.getString("AUTHOR"));
                v.setCreation_date(rs.getString("CREATION_DATE"));
                v.setDuration(rs.getString("DURATION"));
                v.setViews(rs.getInt("VIEWS"));
                v.setDescription(rs.getString("DESCRIPTION"));
                v.setFormat(rs.getString("FORMAT"));
                v.setUrl(rs.getString("URL"));
                v.setUploader(rs.getString("UPLOADER"));
                videos.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return videos;
    }
    
    public static Video getVideoByID(int id){
        ArrayList<Video> videos = null;
        try {
            Statement statement;
            ResultSet rs;
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
            rs = statement.executeQuery("SELECT * FROM videos WHERE id="+id+"");
            videos = new ArrayList();
            while(rs.next()){
                Video v = new Video();
                v.setId(rs.getInt("ID"));
                v.setTitle(rs.getString("TITLE"));
                v.setAuthor(rs.getString("AUTHOR"));
                v.setCreation_date(rs.getString("CREATION_DATE"));
                v.setDuration(rs.getString("DURATION"));
                v.setViews(rs.getInt("VIEWS"));
                v.setDescription(rs.getString("DESCRIPTION"));
                v.setFormat(rs.getString("FORMAT"));
                v.setUrl(rs.getString("URL"));
                v.setUploader(rs.getString("UPLOADER"));
                videos.add(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(videos.isEmpty()){
            return null;
        }else{
            return videos.get(0);
        }
        
    }
    
    public static int addView(int id){
        
        Video v = getVideoByID(id);
        if (v!=null){
            v.setViews(v.getViews()+1);
            try {
                Statement statement;
                statement = connection.createStatement();
                statement.setQueryTimeout(30);
                return statement.executeUpdate("UPDATE videos SET views='"+v.getViews()+"' WHERE id='"+v.getId()+"';");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }
        }else{
            return -1;
        }
        
        
        
    }
    
    public static void disconnect(){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
