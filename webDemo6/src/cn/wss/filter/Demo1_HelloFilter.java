package cn.wss.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="helloFilter",urlPatterns={"/demo1_2.jsp","/demo3_3.jsp"},
dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST})
public class Demo1_HelloFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1.helloFilter before doFilter");
		//放行
		chain.doFilter(arg0, arg1);
		//多个 Filter 可以构成一个 Filter 链. 	
		//把请求传给 Filter 链的下一个 Filter,若当前 Filter 是 Filter 链的最后一个 Filter, 将把请求给到目标 Serlvet(或 JSP)
		System.out.println("2.helloFilter after  doFilter");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		//类似于servlet的init方法，加载web应用时调用，只被调用一次
		//用于初始化，Filter实例是单例
		//FilterConfig 类似于 ServletConfig 获取filtername等属性
//		System.out.println("init");
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
		//释放当前 Filter 所占用的资源的方法. 在 Filter 被销毁之前被调用, 且只被调用一次. 
//		System.out.println("destroy");
	}

}
