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

@WebFilter(filterName="nameFilter",urlPatterns="/demo2_2hello.jsp",
			initParams = {@WebInitParam(name="username", value="Tom")})
public class Demo2_1NameFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String initUser = filterConfig.getInitParameter("username");
		String username = request.getParameter("username");
		
		if(!initUser.equals(username)){
			request.setAttribute("message", "�û�������ȷ");
			request.getRequestDispatcher("/demo2_1login.jsp").forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}
	private FilterConfig filterConfig;
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
