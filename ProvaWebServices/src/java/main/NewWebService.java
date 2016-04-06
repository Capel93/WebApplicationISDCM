/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author JoanMarc
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "euro2ptas")
    public int euro2ptas(@WebParam(name = "euros") double euros) {
        //TODO write your implementation code here:
        return (int)( euros * 166.386 );
    }
}
