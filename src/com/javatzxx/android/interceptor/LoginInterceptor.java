package com.javatzxx.android.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.javatzxx.android.entity.UserEntity;
import com.javatzxx.android.service.UserService;
public class LoginInterceptor{
	
}

//public class LoginInterceptor implements HandlerInterceptor{
//	@Resource
//	private UserService userService;
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//			Object obj) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("我要准备进入controller了！");
//		
//		String user_id = (String) request.getAttribute("user_id");
//		String controllerDo=request.getServletPath();
//		System.out.println(controllerDo);
//		UserEntity userEntity=userService.queryUserByName("123");
//		System.out.println(userEntity.toString()+"interceptor调用service成功");
//		if (controllerDo.matches("^/androiduser/(.*)") || controllerDo.equals("/")  
//				 || controllerDo.matches("^/user/(.*)")) {
//			System.out.println("请求成功让你进controller");		
//			return true;
//		} else if(user_id != null){		
//			System.out.println("请求成功让你进controller");		
//			return true;
//		}else{
////			response.setStatus(401);
////			response.setHeader("Cache-Control", "no-store");
////			response.setDateHeader("Expires", 0);
////			response.setHeader("WWW-authenticate", "Basic Realm=\"你的请求没有那个识别码，请重新登录\"");			
//			System.out.println("请求失败controller");
//			return false;
//		}
//		//response.sendRedirect("/login.jsp");
//		//return true;
//	}
//
//	public void postHandle(HttpServletRequest request, HttpServletResponse response,
//			Object obj, ModelAndView mav) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("我要准备解析view了！");		
//	}
//
//	public void afterCompletion(HttpServletRequest request,
//			HttpServletResponse response, Object obj, Exception e)
//			throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("当前请求接收哦！");	
//	}
//	
//}
