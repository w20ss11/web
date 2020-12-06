package cn.wss.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="passwordFilter",urlPatterns="/demo2_2hello.jsp",
			initParams = {@WebInitParam(name="password", value="123456")})
public class Demo2_2PasswordFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String initPassword = filterConfig.getServletContext().getInitParameter("password");
		String password = request.getParameter("password");
		System.out.println(initPassword);
		System.out.println(password);
		if(!initPassword.equals(password)){
			request.setAttribute("message", "ÃÜÂë²»ÕýÈ·");
			request.getRequestDispatcher("/demo2_1login.jsp").forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}
	private FilterConfig filterConfig;

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}
}
