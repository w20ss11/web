package cn.wss.filter;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName="encodingFilter",urlPatterns="/demo5_2encoding.jsp",
			initParams = {@WebInitParam(name="encoding", value="UTF-8")})
public class Demo5_EncodingFilter extends HttpFilter {

	private String encoding;
	@Override
	protected void init() {
		super.init();
		encoding = getFilterConfig().getInitParameter("encoding");
//		System.out.println("³õÊ¼»¯µÄ×Ö·û±àÂë£º"+encoding);
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("demo5 do filter");
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);

	}

}
