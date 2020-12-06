package cn.wss.filter.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Զ���� HttpFilter, ʵ���� Filter �ӿ�
 *
 */
public abstract class HttpFilter implements Filter {
	
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		this.filterConfig = filterConfig;
		init();
	}

	/**
	 * ������̳еĳ�ʼ������. ����ͨ�� getFilterConfig() ��ȡ FilterConfig ����. 
	 */
	protected void init() {}

	
	/**
	 * ԭ���� doFilter ����, �ڷ����ڲ��� ServletRequest �� ServletResponse 
	 * תΪ�� HttpServletRequest �� HttpServletResponse, �������� 
	 * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	 * 
	 * ����д Filter �Ĺ��˷���������ֱ�Ӽ̳и÷���. ������̳�
	 * doFilter(HttpServletRequest request, HttpServletResponse response, 
	 *		FilterChain filterChain) ����
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		doFilter(request, response, chain);
	}
	
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws IOException, ServletException;
	
	public FilterConfig getFilterConfig(){
		return filterConfig;
	}

	@Override
	public void destroy() {
		Filter.super.destroy();
	}
	
	/**
	 * ���󷽷�, Ϊ Http ������. ����ʵ�ֵķ���. 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	
}
