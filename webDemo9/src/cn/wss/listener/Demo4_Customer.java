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
		
		System.out.println("bind:绑定到 session");
		
		Object value = event.getValue();
		System.out.println("bind:HttpSessionBindingEvent:"+(value == this));
		System.out.println("bind:HttpSessionBindingEvent:"+event.getName()); 
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("bind:从 sessoin 中解除绑定");
	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("activation:从内存中写到磁盘上...");
	}

	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("activation:从磁盘中读取出来...");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", time: " + time;
	}
}
