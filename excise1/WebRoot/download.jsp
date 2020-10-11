<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
    <head>
        <meta charset="UTF-8">
        <title>下载</title>
        <link rel="stylesheet" href="./download.css">
    </head>
    <body style="background-image: url(./image/preview.jpg); background-position: center center; background-size: 100%;">
        <span id="dd">当前用户：${chrName}</span>
        <a id="cc" href="servlet/LogoutController">【安全退出】</a>
        <br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="main.jsp">首页</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="download.jsp">下载</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="javascrpit:;">增加</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="javascrpit:;">查询</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="javascrpit:;">论坛</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="aa" href="javascrpit:;">关于</a>
        <br>
        <span id="t">资源下载</span>
        <br><br><br>
        <p class="title">《word》</p>
        <span id="x"><img src="./image/word.png" alt="word" >这是一个word文件</span>
        <br> <span id="xx">时间:2020-9.30 大小:11MB 星级: <img id="p1" src="./image/5star.png" alt="stars"></span>
        <a id="k" href="download/word1.doc" download>下载</a>
        <br><br>
        <p class="title1">《ppt》</p>
        <span id="xxx"><img src="./image/ppt.png" alt="word" >这是一个ppt文件</span>
        <br> <span id="xxxx">时间:2020-9.30 大小:11MB 星级: <img id="p1" src="./image/5star.png" alt="stars"></span>
        <a id="kk" href="download/ppt1.ppt" download>下载</a>
        <p class="back"><a href="main.jsp">返回首页</a></p>
    </div>
    </body>
</html>