<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.User" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.servlet.http.HttpSession" %>
<%@ page import= "java.io.File" %>
<%@ page import= "utility.UserListComponent" %>
<% User LoginUser = (User)session.getAttribute("user"); %>
<%
File[] slideList =  (File[])request.getAttribute("slide-list");
%>

<% UserListComponent listCompornent = new UserListComponent(); %>
<% ArrayList<String> userList = listCompornent.getUserList(); %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
       <title>Slide</title>

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
	<li><a href="../hazelab/MoveTopServlet"><span class="fui-home"></span></a></li>
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
    <li class="active"><a href="../hazelab/GetSlideServlet"><span class="fui-play"></span></a>
    <li><a href="../hazelab/setting.jsp"><span class="fui-user"></span></a></li>
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
      <form>
      <table class="table table-bordered table-hover table-condensed">
       <thead>
        <tr><th>メンバー</th></tr>
       </thead>
       <tbody>
       <%for(int i=0; i<userList.size(); i++){ %>
       <%String userName = (String)userList.get(i);%>
        <tr><td><a href="../hazelab/GetUserTweetServlet?id=<%=userName %>"><%=userName %></a></td></tr>
       </tbody>
       <% } %>
      </table>
      </form>
     </div>
     <div class="span9">
      <div class="box">
        <div class="box-header">Your Slide</div>
        <form action="./ViewSlideServlet" method="post">
        <%if (slideList.length == 0){ %>
        <br>
        <font size="5" color="#FF00FF">You have no Slide</font>
        <%} %>
        <%if (slideList.length != 0) {%>
        <%for(int i=0; i<slideList.length; i++){ %>
        <%File slides = slideList[i]; %>
        <%if(!(slides.getName().startsWith("."))){ %>
          <div class="row-fluid">
            <div class="span6">
              <fieldset>
                <p><a href="./ViewSlideServlet?slide_name=<%=slides.getName() %>"><%=slides.getName() %></a><span class="fui-document"></span></p>
              </fieldset>
            </div>
          </div>
          <%} %>
          <%} %>
          </form>
        </div>
        <%} %>
      </div>
     </div>
  	</div>
  </body>
 </html>