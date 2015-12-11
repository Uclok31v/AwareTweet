<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AwareTweet　LogIn</title>

    <link href="../../css/vendor/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/login.css" rel="stylesheet">

  </head>
  <body>
　　

	<div class="container">
	    <div class="row">
	        <div class="col-md-12">
	            <div class="wrap">
	                <p class="form-title">Aware Tweet</p>
	                <center><font color="red">${error}</font></center>
	                <form class="login" method="post" action="./LoginServlet">
	                <input type="text" placeholder="UserID" name="user_id" required="" autofocus="" />
	                <input type="password" placeholder="Password" name="password" required=""/>
	                <input type="submit" value="Log In" class="btn btn-success btn-sm" />
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="../../js/vendor/bootstrap.min.js"></script>
    <script src="../../js/login.js"></script>
  </body>
</html>
