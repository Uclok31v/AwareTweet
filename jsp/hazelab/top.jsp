<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.User" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
       <title>AwareTweet Top</title>

    <link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
   
  </head>
  <body style="padding-top:70px;">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
	<div class="navbar-header">
	<a class="navbar-brand">AwareTweet</a>
	</div>
	
	<ul class="nav navbar-nav navbar-left">
	<li class="active"><a href="./top.jsp"><span class="glyphicon glyphicon-home"></span> トップ</a></li>
    </ul>
    <form class="navbar-form navbar-left">
     <div class="form-group">
      <input type="text" class="form-control" placeholder="AwareTweetを検索">
     </div>
     <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
    </form>
    <ul class="nav navbar-nav navbar-right">
    <li><a>設定</a></li>
	<li><a href="./LogOutServlet">ログアウト</a></li>
	</ul>
	
    </div>
	</nav>
    
    <div class="container">
    <div class="col-md-3">
     <div class="well">
     <p>ログインユーザ</p>
     </div>
     <br>
     <ul class="nav navbar-default nav-stacked">
      <li class="active"><a href="#">menue1</a></li>
      <li><a href="#">menue2</a></li>
      <li><a href="#">menue3</a></li>
      <li><a href="#">menue4</a></li>
      <li><a href="#">menue5</a></li>
     </ul>
    </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>