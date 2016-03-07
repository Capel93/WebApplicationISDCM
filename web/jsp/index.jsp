
<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Horizontal form</h2>
  <%
    if(request.getParameter("nickname")!=null)
    {
        if(request.getParameter("nickname").equals("null"))
        { 
          
            %>    

            <div id="labelPassword" class="alert alert-warning">
                <strong>Warning!</strong> Nickname or Password are not correct! Try again.
            </div>

            <% 
        }
    }
    %>
  
    <form class="form-horizontal" role="form" action="servletLoginUser" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="nickname">NickName:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="nickname" id="nickname" placeholder="Enter NickName">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
     
  </form>
  
    
</div>

</body>
</html>

