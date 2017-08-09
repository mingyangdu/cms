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
		$('#form1').attr('action','<%=path %>/user/createUser.do');
				
       // alert("注册完成按钮 is be clicked"); 
        
        var flag=true;
        var flag2=true;
    	//验证用户数据
    	var eventName=$('#nameid').val();
    	var eventPass=$('#passid').val();
    	if(eventName==''){
    		 document.getElementById("eventName_err").innerHTML="<font color='red'>用户名不能为空</font>"; 
    		flag=false;
    	}else{
    		document.getElementById("eventName_err").innerHTML="";
    		
    	}
    	if(eventPass==''){
    		
    		 document.getElementById("eventPass_err").innerHTML="<font color='red'>密码不能为空</font>"; 
    		flag2=false;
    	}else{
    		 document.getElementById("eventPass_err").innerHTML=""; 
    		flag2=true;
    	}
    	
    	if(flag&flag2){
    		$('form:eq(0)').submit();
    		/* $('#form1').submit(); */
    	}	
        
	}
	
	function check()  
    {
		//alert("到check方法");
		var userName = $.trim($("#nameid").val()); 
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
          
                        document.getElementById("eventName_err").innerHTML="<font color='green'>用户名可用</font>"; 
     
                    }else if(data=="2")  
                    {  
                       
                        document.getElementById("eventName_err").innerHTML="<font color='red'>用户名已经被占用</font>"; 
                        
                    }
                },  
                error:function()  
                {  
                    alert("加载失败！");  
                }  
            });  
                  
    }  
</script>
<body>
	This is my JSP page. <br>
	<form id="form1" action="" method="post">
	<table>
		<tr>
				<td align="center">用户名称：</td>
				<td align="center" ><input id='nameid' name="name" onchange="check()" /></td>
				<td align="center"><span id="eventName_err" class="err"></span></td>
		</tr>
		<tr>
			<td align="center">用户密码：</td>
			<td align="center">
				<input id='passid' type="password" name="pass"/>
			</td>
			<td colspan=2 ><span id="eventPass_err" class="err" ></span></td>
		</tr>
		<tr align="center">
			<td align="center">
				<input type="button" onclick="new_user()" value="确认注册"/>
				<input type="button" id="close" value="&nbsp;关闭&nbsp;" onclick="window.history.back();">
			</td>
		</tr>
		<tr>
    		
    		<td colspan=2 ><span id="eventPass_err" class="err"></td>
    	</tr>
	</table>
</form>


</body>
</html>