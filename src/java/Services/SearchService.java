/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchWithVideoName")
    public List<Video> searchWithVideoName(@WebParam(name = "name") String name) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchVideoWithAuthor")
    public List<Video> searchVideoWithAuthor(@WebParam(name = "author") String author) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchVideoWithYearCreationDate")
    public List<Video> searchVideoWithYearCreationDate(@WebParam(name = "date") Date date) {
        //TODO write your implementation code here:
        return null;
    }
    
    
}
