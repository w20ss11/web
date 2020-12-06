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
		//����
		chain.doFilter(arg0, arg1);
		//��� Filter ���Թ���һ�� Filter ��. 	
		//�����󴫸� Filter ������һ�� Filter,����ǰ Filter �� Filter �������һ�� Filter, �����������Ŀ�� Serlvet(�� JSP)
		System.out.println("2.helloFilter after  doFilter");
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		//������servlet��init����������webӦ��ʱ���ã�ֻ������һ��
		//���ڳ�ʼ����Filterʵ���ǵ���
		//FilterConfig ������ ServletConfig ��ȡfiltername������
//		System.out.println("init");
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
		//�ͷŵ�ǰ Filter ��ռ�õ���Դ�ķ���. �� Filter ������֮ǰ������, ��ֻ������һ��. 
//		System.out.println("destroy");
	}

}
