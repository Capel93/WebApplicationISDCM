/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Controller.ConnectionJDBC;
import Model.Video;
import java.sql.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author JoanMarc
 */
@WebService(serviceName = "SearchService")
public class SearchService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchWithVideoTitle")
    public List<Video> searchWithVideoName(@WebParam(name = "title") String title) {
        //TODO write your implementation code here:
        ConnectionJDBC.connect();
        return ConnectionJDBC.getVideosByTitle(title);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchVideoWithAuthor")
    public List<Video> searchVideoWithAuthor(@WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        ConnectionJDBC.connect();
        return ConnectionJDBC.getVideosByAuthor(author);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchVideoWithCreationYear")
    public List<Video> searchVideoWithCreationYear(@WebParam(name = "year") int year) {
        ConnectionJDBC.connect();
        return ConnectionJDBC.getVideosByYear(year);
    }

    
    
}
