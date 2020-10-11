<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link href="style.css" rel="stylesheet" />
    <script>
        function changeImg(){
        document.getElementById("vcodeImg").src="CreateVerifyImage.do?t="+Math.random();
    }
    </script>
</head>
<body style="background-image: url(./image/3.JPG); background-position: center center; background-size: 100%;">
    
    <%!String name;
       String pwd;
    %>
	
	<%  
		Cookie[] cookies = request.getCookies();
	 	for(Cookie cookie:cookies){
	 		if(cookie.getName().equals("name")){
	 			name=cookie.getValue();
             }
             if(cookie.getName().equals("pwd")){
                 pwd=cookie.getValue();
             }
         }
         
    %>
    
    <div id="loginForm">
    <form class="box" action="login.do" method="post">
        <h1>Login</h1>
        <input id="userName" type="text" name="userName" value="<%=(name==null?"":name)%>" placeholder="用户名" />
        <input id="password" type="password" name="password" value="<%=(pwd==null?"":pwd)%>" placeholder="密码">
        <input id="vcode" type="text" name="vcode" placeholder="验证码"
        style="height:15px;position: relative; top:0px; font-size:15px;"id ="text">
        <img id="vcodeImg" style="cursor: pointer;" src="CreateVerifyImage.do" onclick="changeImg();" title="看不起，换一个" />
        <input type="checkbox" name="login" value="flag" /><span style="color:tomato">七天免登陆</span><br/>
        <input id="btLogin" type="submit" value="登&nbsp;&nbsp;录" />
    </form>
</div>
</body>
</html>

<!-- value="<%=(name==null?"":name)%>"  value="<%=(pwd==null?"":pwd)%>"  -->