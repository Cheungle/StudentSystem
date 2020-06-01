package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
 @WebFilter(filterName="/LoginFilter",urlPatterns= {"*.do","*.jsp","*.action"}) 
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        HttpSession session = req.getSession(true);
        PrintWriter out = res.getWriter();
        String request_uri = req.getRequestURI();
        String ctxpath = req.getContextPath();
        String uri = request_uri.substring(ctxpath.length());
		res.setContentType("text/html;"); res.setCharacterEncoding("UTF-8"); 
		 
        if(uri.contains("login.jsp")|| uri.contains("loginva")) {
        	chain.doFilter(request, response);
        }
        else {
        	if(session.getAttribute("username")!="") {
        		//System.out.print(session.getAttribute("username"));
        		chain.doFilter(request, response);
        		
        	}else {
        		out.println("Please login!It will be back to page login after 3 seconds.");
        		res.setHeader("refresh", "3;url="+ctxpath+"/login.jsp");
        		return;
        	}
        }
        // pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
