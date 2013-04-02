<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
  <head>
    <html:base />
    
    <title>小邪微博&nbsp;|&nbsp;用户设置</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/pub.css"/>
<link rel="stylesheet" type="text/css" href="css/config.css"/>
<script src="js/pub.js"></script>
<script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
<link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/WebCalendar.js"></script>
</head>
  
 <body>
<!--上部边栏-->
<div id="sidebartop">
  <div id="logo">
    <!--logo-->
    <div id="logos" onclick="javascript:void(0)"><img src="image/logo.jpg" /></div>
    <!--end logo-->
    <!--导航栏-->
    <div>
      <div id="daohang">
        <ul>
          <li><a href="login.do" style="background-color:#FFF; color:#000">我的首页</a></li>
          <li><a href="huati.do">话题</a></li>
          <li><a href="guangbo.do">广播</a></li>
          <li><a href="visit.do">浏览</a></li>
          <li><a href="about.jsp">关于</a></li>
        </ul>
      </div>
      <div id="daohang2">
        <ul>
         <logic:present name="umspn" scope="session">
			<logic:notEmpty name="umspn" scope="session">
			<bean:define id="myUser" name="umspn" scope="session" property="user"></bean:define>
				<li>
					<a href="login.do"><bean:write name="myUser" property="uName"/></a>
				</li>
		</logic:notEmpty>
		</logic:present>
          <li><a href="config.jsp">设置</a></li>
          <li><a href="html.jsp">帮助</a></li>
          <li><a href="javascript:void(0)">邀请好友</a></li>
          <li><a href="logout.do">退出</a></li> 
        </ul>
      </div>
    </div>
    <!--导航栏结束-->
  </div>
</div>
<!--上部边栏结束-->
<!--内容开始-->
<div id="sidebarcenter">
  <div id="search">
    <form id="search-form" action="search.do" onsubmit="return searcheck()">
      <input type="text" id="scon" name="scon" value="请输入关键字..." onfocus="clearsearch()"/>
      &nbsp;
      <label>
        <select name="type" id="type">
          <option value="neirong">内容</option>
          <option value="yonghu">用户</option>
          <option value="huati">话题</option>
        </select>
      </label>
      &nbsp;
      <input type="submit" value="搜索" />
    </form>
  </div>
  <!--中间内容-->
  <div id="content">
    <div id="TabbedPanels1" class="TabbedPanels">
      <ul class="TabbedPanelsTabGroup">
        <li class="TabbedPanelsTab" tabindex="0">个人信息设置</li>
        <li class="TabbedPanelsTab" tabindex="1">页面设置</li>
        <li class="TabbedPanelsTab" tabindex="2">隐私设置</li>
      </ul>
      <div class="TabbedPanelsContentGroup">
        <div class="TabbedPanelsContent" style="height:600px;">
          <!--个人信息设置-->
          <div id="cfg-title">
            <h3>设置个人信息</h3>
          </div>
          <div id="cfg-content">
            <form id="form1" name="form1" method="post" action="ConfigServlet" enctype="multipart/form-data">
              
              修改昵称:
              <input type="text" name="cuname" id="cuname" value='<bean:write name="myUser" property="uName"/>'/>
              <span id="procunmail"></span><br />
              真实姓名:
              <input type="text" name="cutname" id="cutname" />
              <span id="procutname"></span><br />
              您的性别:
              <input type="radio" id="cusex" name="cusex" value="man"
              style="width:20px; height:20px;" checked="checked"/>
              男
              <input type="radio" id="cusex" name="cusex" value="woman" 
              style="width:20px; height:20px;"/>
              女 <span id="procusex"></span><br />
              修改头像:
              <input type="file" id="cupic" name="cupic" />
              <br />
              您的生日:
              <input type="text" id="cubirth" name="cubirth" onclick="new Calendar().show(this);"/>
              <span id="procubirth"></span><br />
              您的住址:
              <select id="cuaddr" name="cuaddr">
                <option value="beijing">北京</option>
                <option value="shanghai">上海</option>
                <option value="other">其他</option>
              </select>
              <span id="procuaddr"></span><br />
              QQ&nbsp;号码:&nbsp;
              <input type="text" id="cuqq" name="cuqq" />
              <span id="procuqq"></span><br />
              MSN号码:&nbsp;
              <input type="text" id="cumsn" name="cumsn" />
              <span id="procumsn"></span><br />
              个人简介:
              <textarea id="cusyn" name="cusyn">
              </textarea>
              <br />
              <div id="cfg-code">
                <div style="float:left; height:70px;">
                  请输入验证码：
                    <input type="text" name="code" id="code" style="width:100px; height:20px; margin-top:28px;"/>
                </div>
                <div id="code-img"><img width="80" height="50" src="checkCode.do"/><br />
                  <a href="javascript:void(0)">看不清？换一张！</a> &nbsp;&nbsp;<span id="procode"></span></div>
              </div>
              <br />
              <input type="submit" name="sub" id="sub" value="提交" style="width:100px; color:#333;height:25px;font-size:18px;background-color:#CCC;"/>
              &nbsp;&nbsp;
              <input type="button" name="res" id="res" value="重填" style="width:100px; color:#333;height:25px;font-size:18px;background-color:#CCC;"/>
              <br />
            </form>
          </div>
          <!--个人信息设置结束-->
        </div>
        <div class="TabbedPanelsContent">页面设置</div>
        <div class="TabbedPanelsContent">隐私设置</div>
      </div>
    </div>
  </div>
  <div style="font: 0px/0px sans-serif;clear: both;display: block"> </div>
  <!--中间内容结束-->
</div> 
<!--内容结束-->
<!--底部边栏-->
<div id="sidebarbottom">
  <ul>
    <li><a href="#">关于我们</a></li>
    <li><a href="#">联系我们</a></li>
    <li><a href="#">使用协议</a></li>
    <li><a href="#">隐私条款</a></li>
    <li><a href="#">加入我们</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">京ICP100001</a></li>
  </ul>
</div>
<!--底部边栏结束-->
<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</body>
</html:html>
