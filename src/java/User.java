/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Josepd
 */
public class User {
    private String name;
    private String lastName;
    private String mail;
    private String nickname;
    private String password;

    
    User (String name, String lastName, String mail, String nickname, String password){
        this.name = name;
        this.lastName = lastName;
        this.mail = mail; 
        this.nickname = nickname;
        this.password = password;
    }
    
    public boolean CreateUser(){
        
        return true;
    }
    
    public boolean Exists(){
        return false;
    }
    
}
