<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.User" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.servlet.http.HttpSession" %>
<%@ page import= "utility.GetUserListCompornent" %>
<%@ page import= "java.io.File" %>
<% User LoginUser = (User)session.getAttribute("user"); %>

<% GetUserListCompornent listCompornent = new GetUserListCompornent(); %>
<% File[] userList = listCompornent.getUserList(); %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
       <title>Setting</title>

    <link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/vendor/bootstrap.css" rel="stylesheet">
    <link href="../../css/flat-ui.css" rel="stylesheet">
    
    <script type="../../js/dropzone.js"></script>
   
  </head>
  
  <body style="padding-top:70px;">
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
	<div class="navbar-header">
	 <a class="navbar-brand">AwareTweet</a>
	</div>
	
	<ul class="nav navbar-nav navbar-left">
	<li><a href="../hazelab/top.jsp"><span class="fui-home"></span></a></li>
    </ul>
    <form class="navbar-form navbar-left" action="#" role="search">
     <div class="form-group">
      <div class="input-group">
       <input class="form-control" id="navbarInput-01" type="search" placeholder="AwareTweet検索">
        <span class="input-group-btn">
         <button type="submit" class="btn"><span class="fui-search"></span></button>
        </span>
      </div>
     </div>
    </form>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="../hazelab/GetSlideServlet"><span class="fui-play"></span></a>
    <li class="active"><a href="../hazelab/setting.jsp"><span class="fui-user"></span></a></li>
	<li><a href="../common/LogOutServlet"><span class="fui-power"></span></a></li>
	</ul>
	
    </div>
   </nav>
   
   <div class="container">
     <div class="col-md-3">
      <div class="well">
      	<div id="avatar" class="muted">
  			<img src=<%=LoginUser.getAvator_path()%> style="with: 120px; height: 120px;"/>
 		</div>
       <p><%=LoginUser.getUser_name()%></p>
      </div>
     <br>
      <ul class="nav navbar-default nav-stacked">
      <%for(int i=0; i<userList.length; i++){ %>
      <%if (!(userList[i].getName().startsWith("."))) {%>
      <%if (!(userList[i].getName().equals("default"))) {%>
       <li><a href="#"><%=userList[i].getName() %></a></li>
       <%} %>
       <%} %>
       <%} %>
      </ul>
     </div>
    
    <div class="span9">
      


      

      <div class="box">
        <div class="box-header">Change Avator</div>
        <form action="./UploadServlet" method="post" enctype="multipart/form-data">
        <div class="box-content">
          <div class="row-fluid">
            <div class="span6">
              
              
              <fieldset>
                <label for="fullName" class="strong">Full Name: <%=LoginUser.getUser_name() %></label>
             
              </fieldset>
            </div>
            <div class="span6">
              <fieldset>
                <label for="avatar" class="strong">Image (optional):</label>
				<div id="avatar" class="muted">
					<img src=<%=LoginUser.getAvator_path()%> style="with: 120px; height: 120px;"/>
 				</div>
 				<input type="file" name="filname" />
              </fieldset>
            </div>
          </div>
          <div style="margin-top: 20px;">
            <input type="submit" class="btn btn-success" value="Save"/>
            <a href="./top.jsp" class="btn">OK</a>
          </div>
        </div>
        </form>
      </div>
  </div>
</div>
    
    
     
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/vendor/bootstrap.min.js"></script>
    
    
  </body>
</html>

