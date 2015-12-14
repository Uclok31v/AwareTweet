//package utility;
//
//import java.io.IOException;
//import java.util.logging.Logger;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//public class CommonFilter implements Filter{
//
//	private ServletContext context;
//
//	private String loginPage;
//
//	private Logger log = Logger.getLogger(getClass().getName());
//
//	public void init(FilterConfig config) throws ServletException {
//		// コンテキスト取得
//		this.context = config.getServletContext();
//		// URL取得
//		this.loginPage = this.context.getInitParameter("loginPage");
//		if(this.loginPage == null){
//			log.info("login page is not set.Set default value.");
//			this.loginPage = "../../jsp/common/login.jsp";
//		}
//	}
//
//
//	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
//		// ダウンキャスト
//		HttpServletRequest request = (HttpServletRequest) _request;
//		HttpServletResponse response = (HttpServletResponse) _response;
//		// セッション取得
//		HttpSession session = request.getSession();
//		// 認証済みならリクエストページへ
//
//		if(session.getAttribute("user") != null){
//			chain.doFilter(request,response);
//			return;
//		}
//		else {
//			// 未認証ならログインページへ
//			session.invalidate();
//			response.sendRedirect(response.encodeRedirectURL("../../jsp/common/login.jsp"));
//			return;
//		}
//	}
//
//	public void destroy() {
//		// 特記なし
//	}
//}
