/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.61
 * Generated at: 2015-12-11 13:12:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.community;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.User;
import beans.Tweet;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.io.File;
import utility.UserListComponent;
import utility.SlideListComponent;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 User LoginUser = (User)session.getAttribute("user"); 
      out.write('\n');
      out.write('\n');
 UserListComponent listCompornent = new UserListComponent(); 
      out.write('\n');
 ArrayList<String> userList = listCompornent.getUserList(); 
      out.write('\n');
      out.write('\n');
 SlideListComponent slideCompornent = new SlideListComponent(); 
      out.write('\n');
 ArrayList<String> slideList = slideCompornent.getSlideList(); 
      out.write('\n');
      out.write('\n');
      out.write('\n');
 ArrayList tweetList = (ArrayList)request.getAttribute("tweetList"); 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("       <title>AwareTweet Top</title>\n");
      out.write("\n");
      out.write("    <link href=\"../../css/vendor/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../../css/flat-ui.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../../css/link.css\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css\">\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.10.2.js\"></script>\n");
      out.write("    <script src=\"../../js/vendor/bootstrap.min.js\"></script>\n");
      out.write(" \t<script src=\"http://code.jquery.com/ui/1.11.4/jquery-ui.js\"></script>\n");
      out.write("   \t<script type=\"text/javascript\">\n");
      out.write("   \t$(function() {\n");
      out.write("\n");
      out.write("   \t\tvar replyUsers = [];\n");
      out.write("   \t\t");
for(int i=0; i<userList.size();i++){
      out.write("\n");
      out.write("   \t\treplyUsers[");
      out.print(i);
      out.write("] = \"@\"+\"");
      out.print(userList.get(i));
      out.write(" \" ;\n");
      out.write("   \t\t");
}
      out.write("\n");
      out.write("\n");
      out.write("   \t\tvar slides = [];\n");
      out.write("   \t\t");
for(int i=0; i<slideList.size();i++){
      out.write("\n");
      out.write("   \t\tslides[");
      out.print(i);
      out.write("] = \"#\"+\"");
      out.print(slideList.get(i));
      out.write(" \" ;\n");
      out.write("   \t\t");
}
      out.write("\n");
      out.write("\n");
      out.write("   \t\tvar pages = [];\n");
      out.write("   \t\t");
for(int i=1; i<=60; i++){ 
      out.write("\n");
      out.write("   \t\tpages[");
      out.print(i-1);
      out.write("] = \"pp.\" + \"");
      out.print(i);
      out.write("\";\n");
      out.write("   \t\t");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   \t\tvar completeWords = replyUsers.concat(slides);\n");
      out.write("   \t\tcompleteWords = completeWords.concat(pages);\n");
      out.write("\n");
      out.write("   \t\tfunction split( val ) {\n");
      out.write("   \t      return val.split( / \\s*/ );\n");
      out.write("   \t    }\n");
      out.write("   \t    function extractLast( term ) {\n");
      out.write("   \t      return split( term ).pop();\n");
      out.write("   \t    }\n");
      out.write("\n");
      out.write("   \t $( \"#comment\" )\n");
      out.write("     // don't navigate away from the field on tab when selecting an item\n");
      out.write("     .bind( \"keydown\", function( event ) {\n");
      out.write("       if ( event.keyCode === $.ui.keyCode.TAB &&\n");
      out.write("           $( this ).data( \"autocomplete\" ).menu.active ) {\n");
      out.write("         event.preventDefault();\n");
      out.write("       }\n");
      out.write("     })\n");
      out.write("     .autocomplete({\n");
      out.write("       minLength: 0,\n");
      out.write("       source: function( request, response ) {\n");
      out.write("         // delegate back to autocomplete, but extract the last term\n");
      out.write("         response( $.ui.autocomplete.filter(\n");
      out.write("        \tcompleteWords, extractLast( request.term ) ) );\n");
      out.write("       },\n");
      out.write("       focus: function() {\n");
      out.write("         // prevent value inserted on focus\n");
      out.write("         return false;\n");
      out.write("       },\n");
      out.write("       select: function( event, ui ) {\n");
      out.write("         var terms = split( this.value );\n");
      out.write("         // remove the current input\n");
      out.write("         terms.pop();\n");
      out.write("         // add the selected item\n");
      out.write("         terms.push( ui.item.value );\n");
      out.write("         // add placeholder to get the comma-and-space at the end\n");
      out.write("         terms.push( \"\" )\n");
      out.write("         this.value = terms.join( \" \" );\n");
      out.write("         return false;\n");
      out.write("       }\n");
      out.write("     });\n");
      out.write("\n");
      out.write("\n");
      out.write("     });\n");
      out.write("     </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("  <body style=\"padding-top:70px\">\n");
      out.write("   <nav class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t<div class=\"navbar-header\">\n");
      out.write("\t <li class=\"active\"><a class=\"navbar-brand\" href=\"../community/MoveTopServlet\">AwareTweet</a></li>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("\t<li><a href=\"../community/adduser.jsp\"><span class=\"fui-plus\">ユーザ追加</span></a></li>\n");
      out.write("    <li><a href=\"../community/GetSlideServlet\"><span class=\"fui-play\"> スライド</span></a>\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("    <li><a href=\"../community/setting.jsp\"><span class=\"fui-user\"> 設定</span></a></li>\n");
      out.write("\t<li><a href=\"../common/LogOutServlet\"><span class=\"fui-power\"> ログアウト</span></a></li>\n");
      out.write("\t</ul>\n");
      out.write("\n");
      out.write("    <form class=\"navbar-form navbar-right\" action=\"../community/SearchTweetServlet\" method=\"post\" role=\"search\">\n");
      out.write("     <div class=\"form-group\">\n");
      out.write("      <div class=\"input-group\">\n");
      out.write("       <input class=\"form-control\" name=\"search_word\" id=\"search_word\" type=\"search\" placeholder=\"AwareTweet検索\">\n");
      out.write("        <span class=\"input-group-btn\">\n");
      out.write("         <button type=\"submit\" class=\"btn\"><span class=\"fui-search\"></span></button>\n");
      out.write("        </span>\n");
      out.write("      </div>\n");
      out.write("     </div>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("   </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("     <div class=\"col-md-3\">\n");
      out.write("\n");
      out.write("      <div class=\"well\">\n");
      out.write("      \t<div id=\"avatar\" class=\"muted\">\n");
      out.write("  \t\t\t<img src=\"");
      out.print(LoginUser.getAvator_path() );
      out.write("\" style=\"with: 120px; height: 120px;\"/>\n");
      out.write(" \t\t</div>\n");
      out.write(" \t   <br>\n");
      out.write("       <p>");
      out.print(LoginUser.getUser_name());
      out.write("</p>\n");
      out.write("      </div>\n");
      out.write("     <br>\n");
      out.write("      <form>\n");
      out.write("      <table class=\"table table-bordered table-hover table-condensed\">\n");
      out.write("       <thead>\n");
      out.write("        <tr><th>メンバー</th></tr>\n");
      out.write("       </thead>\n");
      out.write("       <tbody>\n");
      out.write("       ");
for(int i=0; i<userList.size(); i++){ 
      out.write("\n");
      out.write("       ");
String userName = (String)userList.get(i);
      out.write("\n");
      out.write("        <tr><td><a href=\"../community/GetUserTweetServlet?id=");
      out.print(userName );
      out.write('"');
      out.write('>');
      out.print(userName );
      out.write("</a></td></tr>\n");
      out.write("       </tbody>\n");
      out.write("       ");
 } 
      out.write("\n");
      out.write("      </table>\n");
      out.write("      </form>\n");
      out.write("     </div>\n");
      out.write("\n");
      out.write("     <div class=\"col-md-9\">\n");
      out.write("     <form action=\"../community/TweetServlet\" method=\"post\">\n");
      out.write("      <div class=\"ui-widget\">\n");
      out.write("      <div class=\"form-group\">\n");
      out.write("       <label for=\"comment\"></label>\n");
      out.write("       <textarea name=\"comment\" id=\"comment\" cols=\"50\" rows=\"3\" class=\"form-control\" placeholder=\"いまどうしてる?\" required autofocus></textarea>\n");
      out.write("      </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-sm-offset-10 text-center\">\n");
      out.write("       <button type=\"submit\" class=\"btn btn-info\" ><i class=\"fui-twitter\"></i>ツイート</button>\n");
      out.write("      </div>\n");
      out.write("     </form>\n");
      out.write("      <br>\n");
      out.write("\n");
      out.write("      <div class=\"panel panel-primary\">\n");
      out.write("       ");
 for(int i=0; i<tweetList.size(); i++){ 
      out.write("\n");
      out.write("       ");
 Tweet tweet = (Tweet)tweetList.get(i); 
      out.write("\n");
      out.write("       <div class=\"panel-heading\"><img src=");
      out.print(tweet.getAvator_path() );
      out.write(" style=\"with: 30px; height: 30px;\"/>  <a href=\"../community/GetUserTweetServlet?id=");
      out.print(tweet.getCommenter() );
      out.write("\"><font color=\"white\">");
      out.print(tweet.getCommenter());
      out.write("</font></a></div>\n");
      out.write("       <div class=\"panel-body\"><p>");
      out.print(tweet.getComment());
      out.write("</p></div>\n");
      out.write("       <div class=\"panel-footer\">");
      out.print(tweet.getDate());
      out.write("</div>\n");
      out.write("       ");
} 
      out.write("\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
