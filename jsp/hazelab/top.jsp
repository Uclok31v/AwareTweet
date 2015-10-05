<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.User" %>
<%@ page import= "beans.Tweet" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.servlet.http.HttpSession" %>
<%@ page import= "java.io.File" %>
<%@ page import= "utility.GetUserListCompornent" %>
<% User LoginUser = (User)session.getAttribute("user"); %>

<% GetUserListCompornent listCompornent = new GetUserListCompornent(); %>
<% File[] userList = listCompornent.getUserList(); %>

<% ArrayList tweetList = (ArrayList)request.getAttribute("tweetList"); %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
       <title>AwareTweet Top</title>

    <link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/flat-ui.css" rel="stylesheet">
   
  </head>
  
  <body style="padding-top:70px;">
   <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
	<div class="navbar-header">
	 <a class="navbar-brand">AwareTweet</a>
	</div>
	
	<ul class="nav navbar-nav navbar-left">
	<li class="active"><a href="../hazelab/top.jsp"><span class="fui-home"></span></a></li>
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
    <li><a href="../hazelab/setting.jsp"><span class="fui-user"></span></a></li>
	<li><a href="../common/LogOutServlet"><span class="fui-power"></span></a></li>
	</ul>
	
    </div>
   </nav>
	
    <div class="container">
     <div class="col-md-3">
     	
      <div class="well">
      	<div id="avatar" class="muted">
  			<img src=<%=LoginUser.getAvator_path() %> style="with: 120px; height: 120px;"/>
 		</div>
       <p><%=LoginUser.getUser_name()%></p>
      </div>
     <br>
      <table class="table table-bordered table-hover table-condensed">
       <thead>
        <tr><th>メンバー</th></tr>
       </thead>
       <tbody>
       <%for(int i=0; i<userList.length; i++){ %>
       <%if (!(userList[i].getName().startsWith("."))) {%>
       <%if (!(userList[i].getName().equals("default"))) {%>      
        <tr><td><a href="#"><%=userList[i].getName() %></a></td></tr>
       </tbody>
       <% } %>
       <% } %>
       <% } %>       
      </table>
     </div>
     
     <div class="col-md-9">
     <form action="../hazelab/TweetServlet" method="post">
      <div class="form-group">
       <textarea name="comment" id="comment" cols="50" rows="3" class="form-control" placeholder="いまどうしてる?"></textarea>
      </div>
      <div class="col-sm-offset-10 text-center">
       <input type="submit" value="ツイート" class="btn btn-info">
      </div>
     </form>
      <br>
           
      <div class="panel panel-primary">
       <% for(int i=0; i<tweetList.size(); i++){ %>
       <% Tweet tweet = (Tweet)tweetList.get(i); %>
       <div class="panel-heading"><img src=<%=LoginUser.getAvator_path() %> style="with: 30px; height: 30px;"/>  <%=tweet.getCommenter()%></div>
       <div class="panel-body"><p><%=tweet.getComment()%></p></div>
       <div class="panel-footer"><%=tweet.getDate()%></div>
       <% } %>
      </div>
         
     </div>     
    </div>
    
 　　  

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/vendor/bootstrap.min.js"></script>
  </body>
</html>