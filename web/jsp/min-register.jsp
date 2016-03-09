<div class="container" onload="init()">
        <h2>Register Form</h2>
        <form role="form" id="newUserForm" action="servletRegisterUser" method="post" onsubmit="return validateForm()">
            
                <div class="form-group" style="height: 50px">
                    <label for="name">First name:</label>
                    <input type="text" class="form-control" name="name" id="name" style="width:350px" required><br><br>
                </div>

                <div class="form-group" style="height: 50px">
                    <label for="lastName"> Last name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" style="width:350px" required><br><br>
                </div>

                <div class="form-group" style="height: 50px">
                    <label for="email"> Email:</label>
                    <input type="email" class="form-control" id="email" name="email" onkeyup="checkEmail()" style="width:350px" required><br><br>
                </div>

                <div class="form-group" style="height: 50px">
                    <label for="nickname">User Name:</label>
                    <input type="text" class="form-control" name="nickname" id="nickname" style="width:350px" required><br><br>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group" style="height: 50px">
                            <label for="pass1">Password:</label>
                            <input id="pass1" type="password" class="form-control" name="password" onkeyup="checkPassword()" style="width:350px" required><br><br>
                        </div>
                    </div>
                    <div class="col-md-4" id="lengthPassword" style="padding-top:20px;height:50px;display:none">
                        <div class="alert alert-danger" role="alert"  style="width:400px;height:45px">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true" ></span>
                            <span class="sr-only">Error:</span>
                            Password must have bettween 8 and 10 characters!
                        </div>
                    </div>
                </div>

                <div class="form-group" style="height: 100px">
                    <label for="pass2">Repeat Password:</label>
                    <input id="pass2" type="password" class="form-control" name="password2" onkeyup="checkPassword()" style="width:350px" required> 
                    <br>
                    <div id="labelPassword" class="alert alert-warning" style="display:none">
                        <strong>Warning!</strong> Passwords are not equal!
                    </div>
                </div>
                <br>
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
                chekValidPassword();
                var pass1 = document.getElementById("pass1").value;
                var pass2 = document.getElementById("pass2").value;
                if (pass1 === pass2)  {
                    document.getElementById("labelPassword").style.display = 'none';
                    document.getElementById("pass2").style.backgroundColor ="white";
                }
                else document.getElementById("labelPassword").style.display = 'inline';

            }
            function chekValidPassword(){
                var pass1 = document.getElementById("pass1").value;
                if(pass1.length < 8){
                    document.getElementById("lengthPassword").style.display = 'inline';
                    return false;
                }else{
                    document.getElementById("lengthPassword").style.display = 'none';
                    return true;
                }
                
            }
            
            function checkEmail() {
                if(wrongEmail){
                    var valid;
                    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                    var email = document.getElementById("email").value;
                    valid = re.test(email);
                    if (valid)  wrongEmail = false;
                    
                }

            }
            
            function validateForm(){
                var valid = true;
                
                var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                var email = document.getElementById("email").value;
                valid = re.test(email);
                if (valid)  wrongEmail = true;
                
                var pass1 = document.forms["newUserForm"]["password"].value;
                var pass2 = document.forms["newUserForm"]["password2"].value;
                if ((pass1.length<8)||(pass1 !== pass2)){
                    valid = false;
                }
                  
                return valid;
            }
            
                      
            function init(){
                document.getElementById("labelPassword").style.display = 'none';
                wrongEmail=false;
            }
        </script>