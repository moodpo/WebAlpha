<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="com.xiaoxie.t.domain.Users"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
  <head>
  <html:base />
  <title>小邪微博&nbsp;|&nbsp;注册</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" type="text/css" href="css/pub.css"/>
  <link rel="stylesheet" type="text/css" href="css/sign.css"/>
  <link href="SpryAssets/SpryTabbedPanels.css" rel="stylesheet" type="text/css" />
  <script src="SpryAssets/SpryTabbedPanels.js" type="text/javascript"></script>
  <script src="js/pub.js"></script>
  <script src="js/sign.js"></script>
  </head>
  <body>
<!--登录窗口-->
<div id="light" class="white_content">
  <p style="margin:2px 0;"><b>用户登录:</b></p>
  <div id="dencontent">
    <form action="login.do" method="post" onSubmit="return docheck()" id="form-login">
      <span id="exemail">用户邮箱:
      <input type="text" id="email" name="email" value="请输入邮箱地址..." onFocus="clearuEmail()"/></span>
      <br /><br/>
      <span id="expw">输入密码:
      <input type="password" value="请输入密码..." id="pw" name="pw" onFocus="clearuPW()"/></span>
      <br />
      <input type="submit" value="登录"  id="sub-den"/>
      &nbsp;&nbsp;
      <input type="reset" value="重置" id="res-den"/>
    </form>
    <div id="propemt">登录是否成功提示</div>
  </div>
  <div id="tishi"> <a href="javascript:void(0)" onClick="closedenlu()">关闭</a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="sign.jsp">还没注册</a> </div>
</div>
<div id="fade" class="black_overlay"> </div>
<!--登录窗口结束-->
  <!--上部边栏-->
  <div id="sidebartop">
    <div id="logo">
      <!--logo-->
      <div id="logos" onClick="javascript:void(0)"><img src="image/logo.jpg" /></div>
      <!--end logo-->
      <!--导航栏-->
      <div>
        <div id="daohang">
          <ul>
           <logic:present name="umspn" scope="session">
            <li><a href="mypage.do" style="background-color:#FFF; color:#000">我的首页</a></li>
           </logic:present>
           <logic:notPresent name="umspn" scope="session">
            <li><a href="#" style="background-color:#FFF; color:#000">首页</a></li>
           </logic:notPresent>
            <li><a href="huati.do">话题</a></li>
            <li><a href="guangbo.do">广播</a></li>
            <li><a href="visit.do">浏览</a></li>
            <li><a href="about.jsp">关于</a></li>
          </ul>
        </div>
        <logic:notPresent name="umspn" scope="session">
      <div id="daohang2">
        <ul>
          <li><a href="javascript:void(0)" onclick="dodenlu()">登录</a></li>
          <li><a href="sign.jsp">注册</a></li>
          <li><a href="javascript:void(0)">帮助</a></li>
          <li><a href="javascript:void(0)">邀请好友</a></li> 
        </ul>
      </div>
      </logic:notPresent>
      <logic:present name="umspn" scope="session">
      <div id="daohang2">
			<ul>
			<logic:notEmpty name="umspn" scope="session">
			<bean:define id="myUser" name="umspn" scope="session" property="user"></bean:define>
				<li><a href="login.do"><bean:write name="myUser" property="uName"/></a></li>
			</logic:notEmpty>
				<li><a href="config.jsp">设置</a></li>
				<li><a href="javascript:void(0)">帮助</a></li>
				<li><a href="javascript:void(0)">邀请好友</a></li>
				<li><a href="logout.do">退出</a></li>
			</ul>
	 </div>
	 </logic:present>
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
          <li class="TabbedPanelsTab" tabindex="0">注册</li>
          <li class="TabbedPanelsTab" tabindex="1">登陆</li>
        </ul>
        <div class="TabbedPanelsContentGroup">
          <!--注册-->
          <div class="TabbedPanelsContent">
            <div id="sign-title">
              <h3>用户注册</h3>
            </div>
            <div id="sign-content">
              <form id="form1" name="form1" method="post" action="sign.do" onSubmit="return signCheck()">
                用户邮箱：
                <input type="text" name="uemail" id="uemail" onFocus="disuEmail()"/>
                <span id="prouemail"></span><br />
                创建账号：
                <input type="text" name="uname" id="uname" onFocus="disuName()"/>
                <span id="prouname"></span><br />
                创建密码：
                <input type="password" name="upw" id="upw" onFocus="disuPW()"/>
                <span id="proupw"></span><br />
                确认密码：
                <input type="password" name="ucpw" id="ucpw" onFocus="disucPW()"/>
                <span id="proucpw"></span><br />
                <div id="sign-code">
                  <div style="float:left; height:70px;"> 请输入验证码：
                    <input type="text" name="ucode" id="ucode" style="width:100px; height:20px; margin-top:28px;"/>
                  </div>
                  <div id="code-img"><img width="80" height="50" src="checkCode.do" id="code"/><br />
                    <a href="javascript:void(0)" onclick="changeImg()">看不清？换一张！</a> &nbsp;&nbsp;<span id="procode"></span></div>
                </div>
                <br />
                <input type="submit" name="sub" id="sub" value="提交" style="width:100px; color:#333;height:25px;font-size:18px;background-color:#CCC;"/>
                &nbsp;&nbsp;
                <input type="button" name="res" id="res" value="重填" style="width:100px; color:#333;height:25px;font-size:18px;background-color:#CCC;"/>
                <br />
              </form>
            </div>
          </div>
          <!--注册结束-->
          <!--登陆-->
          <div class="TabbedPanelsContent">用户登陆
            <div></div>
          </div>
          <!--登陆结束-->
        </div>
      </div>
    </div>
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
