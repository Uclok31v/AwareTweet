<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>AwareTweet　LogIn</title>

    <link href="../../css/bootstrap.min.css" rel="stylesheet">

  </head>
  <body>
　　<FORM method="POST" action="./LoginServlet">

<div class="text-center"><h1>AwareTweet</h1></div>

<br>
<br>

<div class="container">
  <div class="col-sm-12 col-md-6 col-md-offset-3">
    <div class="form-group">
		<input type="text" class="form-control" placeholder="UserID" name="user_id">
		<input type="password" class="form-control" placeholder="Password" name="password">
    </div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">
			Log In
		</button>
		<br>
		<br>
	 </div>
</div>
</FORM>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
