<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>New User</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    
    <body onload="init()">
        <div class="container">
        <h2>Register Form</h2>
        <form role="form" id="newUserForm" action="servletRegisterUser" method="post" onsubmit="return validateForm()">
            <div class="form-group" style="height: 50px">
                <label for="name">First name:</label>
                <input type="text" class="form-control" name="name" id="name" style="width:300px" required><br><br>
            </div>
            
            <div class="form-group" style="height: 50px">
                <label for="lastName"> Last name:</label>
                <input type="text" class="form-control" name="lastName" id="lastName" style="width:300px" required><br><br>
            </div>
            
            <div class="form-group" style="height: 50px">
                <label for="email"> Email:</label>
                <input type="email" class="form-control" id="email" name="email" onkeyup="checkEmail()" style="width:300px" required><br><br>
            </div>
            
            <div class="form-group" style="height: 50px">
                <label for="nickname">User Name:</label>
                <input type="text" class="form-control" name="nickname" id="nickname" style="width:300px" required><br><br>
            </div>
            
            <div class="form-group" style="height: 50px">
                <label for="pass1">Password:</label>
                <input id="pass1" type="password" class="form-control" name="password" style="width:300px" required><br><br>
            </div>
            
            <div class="form-group" style="height: 100px">
                <label for="pass2">Repeat Password:</label>
                <input id="pass2" type="password" class="form-control" name="password2" onkeyup="checkPassword()" style="width:300px" required> 
                <br>
                <div id="labelPassword" class="alert alert-warning">
                    <strong>Warning!</strong> Passwords are not equal!
                </div>
            </div>
            
            <input type="submit" class="btn btn-primary" value="Create new user"  >
            
        </form> 
        <br>
        <form action="servletLoginUser" method="get">
            <input type="submit" class="btn btn-primary" value="Go to Login"  >
        </form>
        </div>
        <script>
            var wrongEmail=true;
            
            function checkPassword() {
                var pass1 = document.getElementById("pass1").value;
                var pass2 = document.getElementById("pass2").value;
                if (pass1 === pass2)  {
                    document.getElementById("labelPassword").style.display = 'none';
                    document.getElementById("pass2").style.backgroundColor ="white";
                }
                else document.getElementById("labelPassword").style.display = 'inline';

            }
            
            function checkEmail() {
                if(wrongEmail){
                    var valid;
                    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                    var email = document.getElementById("email").value;
                    valid = re.test(email);
                    if (!valid) document.getElementById("email").style.backgroundColor ="red";
                    else {
                        document.getElementById("email").style.backgroundColor ="white";
                        wrongEmail = false;
                    }
                }

            }
            
            function validateForm(){
                var valid = true;
                
                var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var email = document.getElementById("email").value;
                valid = re.test(email);
                if (!valid) {
                    document.getElementById("email").style.backgroundColor ="red";
                    wrongEmail = true;
                }
                else document.getElementById("email").style.backgroundColor ="white";
                
                var pass1 = document.forms["newUserForm"]["password"].value;
                var pass2 = document.forms["newUserForm"]["password2"].value;
                if (pass1 !== pass2){
                    document.getElementById("pass2").style.backgroundColor ="red";
                    //alert("bitch, passwords ain't equal");
                    valid = false;
                }
                  
                return valid;
            }
            
                      
            function init(){
                document.getElementById("labelPassword").style.display = 'none';
                wrongEmail=false;
            }
        </script>
        
    </body>
</html>
