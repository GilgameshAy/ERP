<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

 <script language="javascript" type="text/javascript">
		
       function check(){
       if(form.userName.value=="")
		 {
			alert("请输入用户名");
			form.userName.focus();
			return;
		}	
      	 if(form.passWord.value=="")
		 {
			alert("请输入密码");
			form.passWord.focus();
			return;
		}
		if(form.passWord.value.length>10||form.passWord.value.length<2)
		{
		  	alert("请将密码长度设为2-10位！！");
			form.passWord.focus();
			return;
		}
       form.submit();
      
      }    
       
   	function next(){
		window.location = "zhuce.jsp";
	}

</script>


<body>
<div>
	<form name="form" method="post" action="${pageContext.request.contextPath}/userServlet"  >
		<table align="center" width="50%" height="70%"> 

		  <tr>
		  	<th height="15" colspan="5">用 户 登 录</th>
		  </tr>
		  <tr> 
		  	<td width="19" height="30"></td>
            <td width="57" align="center">用户名</td>
            <td width="124" colspan="3" align="center"><input type="text" name="userName" id="userName"></td> 
          </tr> 
          <tr> 
		  	<td width="19" height="27"></td>
            <td width="57" align="center">密&nbsp; 码</td>
            <td colspan="3" align="center"><input type="passWord" name="passWord" id="passWord"></td>
          </tr> 
		  <tr>
		  	<td width="19"></td>
	        <td align="center" colspan="3" height="30">
	        <input id="dl" onclick="check()" type="button" name="denglu" value="登陆">
	        <input id="zc" type="button" value="注册" onclick="next()">
	        
			</td>
		  <tr>
        </table> 		
	</form>
</div>
</body>
</html>