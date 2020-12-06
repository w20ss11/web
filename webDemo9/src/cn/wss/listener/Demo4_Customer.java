package cn.wss.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Demo4_Customer implements HttpSessionBindingListener,HttpSessionActivationListener{
private String time;
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public void valueBound(HttpSessionBindingEvent event) {
		
		System.out.println("bind:�󶨵� session");
		
		Object value = event.getValue();
		System.out.println("bind:HttpSessionBindingEvent:"+(value == this));
		System.out.println("bind:HttpSessionBindingEvent:"+event.getName()); 
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("bind:�� sessoin �н����");
	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("activation:���ڴ���д��������...");
	}

	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("activation:�Ӵ����ж�ȡ����...");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", time: " + time;
	}
}
