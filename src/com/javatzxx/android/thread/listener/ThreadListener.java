package com.javatzxx.android.thread.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ThreadListener implements ServletContextListener{

//	@Override
	//服务器关闭执行
	public void contextDestroyed(ServletContextEvent arg0) {
//		 if (myThread != null && myThread.isInterrupted()) {  
//        myThread.interrupt();  
//		}
		
	}
//
//	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//定时启动不适用
//		String str = null;  
//        if (str == null && myThread == null) {  
//            myThread = new MyThread();  
//            myThread.start(); // servlet 上下文初始化时启动 socket  
//        }  
		
	}

}
