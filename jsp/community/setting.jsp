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

   <jsp:include page="global.jsp"/>

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
        <form method="post" action="./SettingServlet">
        <div class="box-content">
          <div class="row-fluid">
          <form action="./SettingServlet" method="post">
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
         </form>
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

