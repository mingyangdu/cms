<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="<%=basePath%>/js/jquery.js"> </script> 
<script language="javascript">
	function new_user(){
		$('#form1').attr('action','<%=path %>/user/create.do');
				
        //alert("注册按钮 is be clicked"); 
        //$('#form1').submit();
        
	} 
	function music(){
		$('#form1').attr('action','<%=path %>/androidmusic/music.do');
				
        //alert("注册按钮 is be clicked"); 
        $('#form1').submit();
        
	} 
	function oncheck(){
		$('#form1').attr('action','<%=path %>/user/login.do');
				
        //alert("注册按钮 is be clicked");         
        var flag=true;
        var flag2=true;
    	//验证用户数据
    	var eventName=$('#name').val();
    	var eventPass=$('#pass').val();
    	if(eventName==''){
    		 document.getElementById("name_err").innerHTML="<font color='red'>用户名不能为空</font>"; 
    		flag=false;
    	}else{
    		document.getElementById("name_err").innerHTML="";
    		
    	}
    	if(eventPass==''){
    		
    		 document.getElementById("pwd_err").innerHTML="<font color='red'>密码不能为空</font>"; 
    		flag2=false;
    	}else{
    		 document.getElementById("pwd_err").innerHTML=""; 
    		flag2=true;
    	}
    	
    	if(flag&flag2){
    		//$('form:eq(0)').submit();
    		/* $('#form1').submit(); */
    	}	
        
	}
	function check()  
    {
		//alert("到check方法");
		var userName = $.trim($("#name").val()); 
        $.ajax(  
            {  
                type:"POST",  
                url:"user/userajax.do",
                data:"userName="+userName,
                dataType:"json",  
                success:function(data)  
                {  
                	//alert(data);
                    if(data=="1")  
                    {  
          
                        document.getElementById("name_err").innerHTML="<font color='red'>用户名不存在</font>"; 
     
                    }else if(data=="2")  
                    {  
                       
                        document.getElementById("name_err").innerHTML="<font color='red'></font>"; 
                        
                    }
                },  
                error:function()  
                {  
                    alert("加载失败！");  
                }  
            });  
                  
    }  
	function logtest()  
    {
		//alert("到check方法");
		var userName = $.trim($("#name").val()); 
        $.ajax(  
            {  
                type:"POST",  
                url:"androidmusic/lognum.do",
                data:"userName="+userName,
                dataType:"json",  
                success:function(data)  
                {  
                	alert(data.lognum);
                  
                        $("#text1").val(data.lognum);
                },  
                error:function()  
                {  
                    alert("加载失败！");  
                }  
            });  
                  
    }  
	function downmusic(){
		var musicName = $.trim($("#musicname").val()); 
		if(window.confirm("提示：你真要下载“"+musicName+"”这么个玩意吗？")){
			window.location.href="<%=path %>/androidmusic/getmusic.do?musicname="+musicName;		
		}		
	}
	function oncheckmusic(){
		var musicName = $.trim($("#musicname").val());
		if(musicName!="" && musicName!=null){
			$("#musicbutton").attr('disabled',false);
		}else{
			$("#musicbutton").attr('disabled',true);
		}
		
	}
	
</script>
  
  <body>
    This is my JSP page. <br>
    <form id="form1" action="" method="post">
    	<table>
    		<tr>
				<td>
					<input id="name" name="name" onchange="" /></td><td><span id="name_err" class="err"></span></td>
				
    		</tr>
    		<tr>
				<td>
					<input id="pass" type="password" name="pass"/>
				</td>
				<td><span id="pwd_err" class="err"></span></td>
    		</tr>
    		<tr>
				<td>
					<input type="button" value="提交" onclick="oncheck()" />
				</td>
    		</tr>
    		<tr>
				<td>
					<input type="button" onclick="new_user()" value="新用户注册"/>
				</td>
    		</tr>
    	
    		<tr>
				<td>
					<a href="music/gloryglorymanunited.mp3" >曼联队歌glory下载</a>
				</td>
    		</tr>
    		<tr>
				<td>
					<a id="yang" href="<%=path %>/androidmusic/getmusic.do?musicname=yangmingshan.mp3" >阳明山io流下载</a>
				</td>
    		</tr>
    		<tr>
				<td>
					&nbsp;
				</td>
    		</tr>
    		<tr>
				<td>
					<a href="<%=path %>/androidmusic/getmusic.do?musicname=gloryglorymanunited.mp3" >曼联队歌glory通过请求io流下载</a>
				</td>
    		</tr>
    		<tr>
				<td>
					&nbsp;
				</td>
    		</tr>
    		<tr>
				<td>
					<a href="<%=path %>/androidmusic/getandroid.do?androidname=tianzhao_footballmusic.apk" >音乐app通过请求io流下载</a>
				</td>
    		</tr>
    		<tr>
				<td>
					<input type="button" onclick="music()" value="获取music地址"/>
				</td>
    		</tr>
    		</tr>
    		<tr>
				<td>
					<input id="musicname" name="musicname" type="text" onchange="oncheckmusic()" />
					<input id="musicbutton" name="musicbutton" type="button" onclick="downmusic()" value="输入歌名下载music（报错说明没这个歌,请加.mp3）" disabled = "true"/>
				</td>
    		</tr>
    		</tr>
    		<tr>
				<td>
					<input type="button" onclick="logtest()" value="测试log的参数变更"/>
				</td>
    		</tr>
    		<tr>
				<td>
					 <input id= "text1" type= "text" readonly /> 只读 
				</td>
    		</tr>
    	</table>
    
    
    </form>
  </body>
</html>