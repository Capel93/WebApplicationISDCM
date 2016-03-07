package Model;

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
    private String email;
    private String nickname;
    private String password;

    
    public User (String name, String lastName, String email, String nickname, String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email; 
        this.nickname = nickname;
        this.password = password;
    }
    
    @Override
    public String toString(){
        return "'"+this.name+"','"+this.lastName+"','"+this.email+"','"+this.nickname+"','"+this.password+"'";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
