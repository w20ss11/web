package cn.wss.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="secondFilter",urlPatterns={"/demo1_2.jsp","/demo3_3.jsp"},
			dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD})
public class Demo1_SecondFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("3.second before doFilter");
		chain.doFilter(arg0, arg1);
		System.out.println("4.second after  doFilter");
		//多个filter顺序在web.xml顺序filter-mapping决定
		//注解方式时，通过控制filter文件名控制顺序
	}
}
