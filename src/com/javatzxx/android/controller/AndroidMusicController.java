package com.javatzxx.android.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlID;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatzxx.android.service.AndroidMusicService;


@Controller
@RequestMapping("/androidmusic")
public class AndroidMusicController {
	static Logger log= Logger.getLogger(AndroidMusicController.class);
//	@Resource
//	private AndroidMusicService androidMusicService;
	//Android访问这个方法t
	@RequestMapping("/music")
	@ResponseBody
	public Object getMusicPath(ModelMap map,HttpSession httpSession,HttpServletRequest request) throws IOException 
	{	
		//为测试Git  专门写了这句话github
		 Map<String, String> maps = new HashMap<String, String>();
		 	Date date=new Date();
		 	SimpleDateFormat s=new SimpleDateFormat("HH:mm:ss");		 	
	        long time2 = date.getTime();  
	        //获得五分钟之后的时间
	        long timeadd=(time2+(1000*300));
	        Date date2=new Date(timeadd);
	        //五分钟之后的时间String
	        String timeString=s.format(date2);
	        //当前时间String
		 	String time=s.format(date);
			maps.put("wangwang", "ok");//预备map 目前防止空指针随意定义
			//获取ip的简单方法不一定适用web	String ip = InetAddress.getLocalHost().getHostAddress(); 
			//以下为获取本地ip 防止变更服务器地址 用在web里面，本方法为强适应性。
			String IPIP="";			
			Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			//获取ip的方法试验
			System.out.println("ip方法1：：：："+InetAddress.getLocalHost().getHostAddress());
			//2.域名解析ip的方法
			System.out.println("ip方法2：：：："+InetAddress.getByName("www.sina.com.cn"));
			//获取本地ip到此结束
			//下面是获取服务器的本地真实路径 用于file的路径参数
			String basePath=httpSession.getServletContext().getRealPath("/");
			
			//求大小：：：
			String realPath=((HttpSession) request).getServletContext().getRealPath("/");
			//linux需要改成/   不是\\
			String fileid = request.getParameter("musicname");    // 获取文件的文件名
			int lastFirst = realPath.lastIndexOf("/");
			System.out.println("服务器文件地址 = " + realPath);
			String realPathOk=realPath.substring(0, lastFirst);
			int lastFirst2 = realPathOk.lastIndexOf("/");
			String realPathOk2=realPathOk.substring(0, lastFirst2);
			
		    FileInputStream fis = new FileInputStream(new File(realPathOk2+"/music/gloryglorymanunited.mp3")); // 
			
			
			//获取文件的大小单位为B，计算方法除以1024
			int bigsmall=fis.available();
			//计算出单位M，的文件大小
			System.out.println((bigsmall/1024/1024));
			//赵飞让加个毫秒时间
			Date datezhao=new Date();
			long timelong=datezhao.getTime();
			String timelongzhao=timelong+"";
			System.out.println("赵飞要的毫秒时间：：："+timelongzhao);
			String musicname = request.getParameter("musicname");
			String musicnametrue="";
			if(!"".equals(musicname) && musicname!=null){
				musicnametrue=musicname;
			}else{
				musicnametrue="gloryglorymanunited.mp3";
			}
			maps.put("musicpath", "/SpringMusicAndroid/androidmusic/getmusic.do?musicname="+musicnametrue);//预备map 目前防止空指针随意定义
			maps.put("musicpath2", "http://"+(InetAddress.getByName("www.sina.com.cn")).toString().split("/")[1]+":8080/SpringMusicAndroid/androidmusic/getmusic.do?musicname="+musicnametrue);//预备map 目前防止空指针随意定义	
			maps.put("systemtimeHH", "8");//预备map 目前防止空指针随意定义time.split(":")[0]
			maps.put("systemtimeMM","1");//预备map 目前防止空指针随意定义 time.split(":")[1]
			maps.put("systemtimeSS", "20");//预备map 目前防止空指针随意定义time.split(":")[2]
			maps.put("overtimeHH","20");//预备map 目前防止空指针随意定义timeString.split(":")[0]
			maps.put("overtimeMM", timeString.split(":")[1]);//预备map 目前防止空指针随意定义
			maps.put("overtimeSS", timeString.split(":")[2]);//预备map 目前防止空指针随意定义
			maps.put("musicsize",(bigsmall+"" ));//预备map 目前防止空指针随意定义
			maps.put("timehaomiao",(timelongzhao ));//预备map 目前防止空指针随意定义
//			List list=new ArrayList();
//			list=todayDataService.queryCustomerFlowChart(map);
//			maps.put("info", list);
		 
			return maps;
	}
	//@RequestMapping(value="/login.do",method=RequestMethod.POST)
	//这个方法目前没用
	@RequestMapping("/login.do")
	public String  updateMusic(ModelMap map,HttpSession httpSession)
	{	
		
		return "redirect:/login.jsp";
	}
	//io流获得下载音乐
	@RequestMapping(value = "/getmusic.do", method = RequestMethod.GET)
	public void  getMusic(ModelMap map,HttpSession httpSession,HttpServletRequest request,HttpServletResponse response) throws IOException
	{	
		String realPath=((HttpSession) request).getServletContext().getRealPath("/");
		
		//linux需要改成/   不是\\
		String fileid = request.getParameter("musicname");    // 获取文件的文件名
		int lastFirst = realPath.lastIndexOf("/");
		System.out.println(realPath);
		String realPathOk=realPath.substring(0, lastFirst);
		int lastFirst2 = realPathOk.lastIndexOf("/");
		String realPathOk2=realPathOk.substring(0, lastFirst2);
		
	    FileInputStream fileInputStream = new FileInputStream(new File(realPathOk2+"/music/"+fileid)); // 
	    int i=fileInputStream.available(); //得到文件大小
	        
	    
	    byte data[]=new byte[i];
	    fileInputStream.read(data);  
	    response.setContentType("audio/mp3"); //设置文件类型
	    response.setHeader("Content-Disposition", "attachment; filename="+fileid);
	    OutputStream outputStream=response.getOutputStream(); //输出文件
	    outputStream.write(data);  //输出数据
	    outputStream.flush();   //   记得关闭喔 
	    outputStream.close();   //   记得关闭喔
	    fileInputStream.close();    //   记得关闭喔
		
	}
	//io流获得下载app
	@RequestMapping(value = "/getandroid.do", method = RequestMethod.GET)
	public void  getAndroid(ModelMap map,HttpSession httpSession,HttpServletRequest request,HttpServletResponse response) throws IOException
	{	
		String realPath=((HttpSession) request).getServletContext().getRealPath("/");
		//linux需要改成/   不是\\
		int lastFirst = realPath.lastIndexOf("/");
		System.out.println(realPath);
		String realPathOk=realPath.substring(0, lastFirst);
		int lastFirst2 = realPathOk.lastIndexOf("/");
		String realPathOk2=realPathOk.substring(0, lastFirst2);
		String fileid = request.getParameter("androidname");    // 获取文件的文件名
		//下载文件重命名
		FileInputStream fileInputStream = new FileInputStream(new File(realPathOk2+"/android/"+fileid)); // 
		int i=fileInputStream.available(); //得到文件大小
		
		byte data[]=new byte[i];
		fileInputStream.read(data);  
		//response.setContentType("audio"); //设置文件类型
		response.setHeader("Content-Disposition", "attachment; filename="+fileid);
		OutputStream outputStream=response.getOutputStream(); //输出文件
		outputStream.write(data);  //输出数据
		outputStream.flush();   //   记得关闭喔
		outputStream.close();   //   记得关闭喔
		fileInputStream.close();    //   记得关闭喔
		
	}
	//log计数测试
	@RequestMapping("/lognum")
	@ResponseBody
	public Object lognum(ModelMap map,HttpSession httpSession,HttpServletRequest request) throws IOException 
	{
		
		//log 日志试验
	    int log_number;
	    Properties prop = new Properties();     
	    //读取属性文件a.properties
        InputStream in = AndroidMusicController. class .getClassLoader().getResourceAsStream( "something_log.properties" );       
        prop.load(in);   
        System.out.println(prop);
        System.out.println(prop.getProperty("log_number"));
        
        log_number=Integer.parseInt(prop.getProperty("log_number"));
	    Iterator<String> it=prop.stringPropertyNames().iterator();
	        while(it.hasNext()){
	        	String key=it.next();
	        	System.out.println(key+":"+prop.getProperty(key));
	        	in.close();
	        };
	    
	    log.info("有人进行了操作");
	    log_number++;
	    ///保存属性到b.properties文件
	   // FileOutputStream oFile = new FileOutputStream("something_log.properties", true);//true表示追加打开
	    prop.setProperty("log_number", Integer.toString(log_number));
//	    prop.store(oFile, "The New properties file");
//	    oFile.close();
        String path = AndroidMusicController.class.getClassLoader().getResource("something_log.properties").getPath();  
        FileOutputStream outputFile = new FileOutputStream(path);  
        prop.store(outputFile, "modify");  
        //prop.save(outputFile, comments);
        outputFile.flush(); 
       
        outputFile.close();  
	    
	    
		    Map maps=new HashMap();
			maps.put("lognum", Integer.toString(log_number));//预备map 目前防止空指针随意定义
			return maps;
	}
}
