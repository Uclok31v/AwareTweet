<%@ page pageEncoding="utf-8" %>


<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
     <div class="container">
     <div class="navbar-header">
      <a class="navbar-brand" href="../community/MoveTopServlet">AwareTweet</a>
      </div>

      <ul class="nav navbar-nav navbar-left">
      <li class="active"><a href="../community/adduser.jsp"><span class="fui-plus">Regist</span></a></li>
      <li><a href="../community/GetSlideServlet"><span class="fui-play">Slide</span></a>
    </ul>

    <ul class="nav navbar-nav navbar-right">
    <li><a href="../community/setting.jsp"><span class="fui-user"> Settings</span></a></li>
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

