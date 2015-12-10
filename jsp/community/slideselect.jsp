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
<% String author = (String)request.getAttribute("author"); %>

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
	<li><a href="../community/MoveTopServlet"><span class="fui-home"> ホーム</span></a></li>
	<li class="active"><a href="../community/GetSlideServlet"><span class="fui-play"><%=author %>のスライド</span></a>
    </ul>

    <ul class="nav navbar-nav navbar-right">
    <li><a href="../community/setting.jsp"><span class="fui-user"> 設定</span></a></li>
	<li><a href="../common/LogOutServlet"><span class="fui-power"> ログアウト</span></a></li>
	</ul>

	<form class="navbar-form navbar-right" action="../community/SearchTweetServlet" method="post" role="search">
     <div class="form-group">
      <div class="input-group">
       <input class="form-control" name="search_word" id="search_word" type="search" placeholder="AwareTweet検索">
        <span class="input-group-btn">
         <button type="submit" class="btn"><span class="fui-search"></span></button>
        </span>
      </div>
     </div>
    </form>

    </div>
   </nav>

   <div class="container">
     <div class="col-md-3">
      <div class="well">
      	<div id="avatar" class="muted">
  			<img src=<%=LoginUser.getAvator_path()%> style="with: 120px; height: 120px;"/>
 		</div>
 	　 <br>
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
        <tr><td><a href="../community/GetUserTweetServlet?id=<%=userName %>"><%=userName %></a></td></tr>
       </tbody>
       <% } %>
      </table>
      </form>
     </div>
     <div class="span9">
      <div class="box">

        <div class="box-header"><font size="6"><%=author%>'s Slides</font></div>
        <form action="./ViewSlideServlet" method="post">
        <%if (slideList.length == 0){ %>
        <br>
        <font size="5" color="#FF00FF">You have no slide</font>
        <br>
        <%} %>
        <%if (slideList.length != 0) {%>
        <%for(int i=0; i<slideList.length; i++){ %>
        <%File slides = slideList[i]; %>
        <%if(!(slides.getName().startsWith("."))){ %>
          <div class="row-fluid">
            <div class="span6">
              <fieldset>
              <form action="./ViewSlideServlet" method="post">
                <p><input type="hidden" name="author" value="<%=author%>">
                <input type = "submit" name="slide_name"  value="<%=slides.getName() %>"><span class="fui-document"></span>

                </p>
                </form>
              </fieldset>
            </div>
          </div>
          <%} %>
          <%} %>
          <%} %>

        </div>
        <%if(author.equals(LoginUser.getUser_id())) {%>
        <form action="./RegistSlideServlet" method="post" enctype="multipart/form-data">
        <label>Regist your Slide</label>
        <input type="file" name="filname" />
        <br>
         <button type="submit" class="btn btn-success"  name="os" value="win"><i class="fui-windows-8"></i> Windowsはこちら</button>
         <button type="submit" class="btn btn-danger" name="os" value="mac"><i class="fui-apple" ></i> Macこちら</button>
        </form>
        <%} %>
      </div>
     </div>
  	</div>
  </body>
 </html>
