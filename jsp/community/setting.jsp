<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import= "beans.User" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "javax.servlet.http.HttpSession" %>
<%@ page import= "utility.UserListComponent" %>
<%@ page import= "java.io.File" %>
<% User LoginUser = (User)session.getAttribute("user"); %>

<% UserListComponent listCompornent = new UserListComponent(); %>
<% ArrayList<String> userList = listCompornent.getUserList(); %>

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
      <a class="navbar-brand" href="../community/MoveTopServlet">AwareTweet</a>
      </div>

      <ul class="nav navbar-nav navbar-left">
      <li><a href="../community/adduser.jsp"><span class="fui-plus">Regist</span></a></li>
      <li><a href="../community/GetSlideServlet"><span class="fui-play">Slide</span></a>
    </ul>

    <ul class="nav navbar-nav navbar-right">
    <li class="active"><a href="../community/setting.jsp"><span class="fui-user"> Settings</span></a></li>
    <li><a href="../common/LogOutServlet"><span class="fui-power"> Logout</span></a></li>
    </ul>

    <form class="navbar-form navbar-right" action="../community/SearchTweetServlet" method="post" role="search">
     <div class="form-group">
      <div class="input-group">
       <input class="form-control" name="search_word" id="search_word" type="search" placeholder="Search">
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
        <div class="box-header">Account Settings</div>
        <form method="post" action="./SettingServlet" enctype="multipart/form-data">
        <div class="box-content">
          <div class="row-fluid">
            <div class="span6">
              <fieldset>
                <label for="fullName" class="strong">Full Name: <input type="text" name="user_name" required value="<%=LoginUser.getUser_name() %>"/></label>
              </fieldset>
            </div>
            <div class="span6">
              <fieldset>
                <label for="fullName" class="strong">Password(input to change password): <input type="password" placeholder="Password" name="password" required=""/></label>
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
            <a href="./MoveTopServlet" class="btn">OK</a>
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

