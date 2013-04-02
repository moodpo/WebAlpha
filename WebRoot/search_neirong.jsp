<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
  <head>
    <html:base />
    
   <title>小邪微博&nbsp;|&nbsp;访问</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/pub.css"/>
<link rel="stylesheet" type="text/css" href="css/visit.css"/>
<script src="js/pub.js"></script>
<script type="text/javascript" src="js/visit.js"></script>
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
    <div id="logos" onclick="javascript:void(0)"><img src="image/logo.jpg" /></div>
    <!--end logo-->
    <!--导航栏-->
    <div>
      <div id="daohang">
        <ul>
        <logic:notPresent name="umspn" scope="session">
          <li><a href="start.do" >首页</a></li>
          </logic:notPresent>
          <logic:present name="umspn" scope="session">
          <li><a href="login.do" >我的首页</a></li>
          </logic:present>
          <li><a href="huati.do">话题</a></li>
          <li><a href="guangbo.do">广播</a></li>
          <li><a href="visit.do" style="background-color:#FFF; color:#000">浏览</a></li>
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
    <!--左边-->
    <div id="main-left">
      <!--search消息-->
      <div id="oldcon">
				<logic:present name="msgSet" scope="request">
				<logic:notEmpty name="msgSet" scope="request">
				<logic:iterate id="myMsg" name="msgSet" scope="request">
					<div style="width: 630px; margin: 0 auto;">
						<!--msg-->
						<div class="msg">
						<div style="height: 10px;"></div>
							<!--img-->
							<div class="msg-img">
								<img src='<bean:write name="myMsg" property="user.uImg"/>' width="60" height="60"/>
							</div>
							<!--end img-->
							<div class="msgandname">
								<!--msgandname-->
								<div class="msgandname_c">
									<a href="visit.do?vuid=<bean:write name='myMsg' property='user.uId'/>"><bean:write name="myMsg" property="user.uName"/></a>: <bean:write name="myMsg" property="mCon" filter="false"/>
								</div>
								<!--end#msgandname-->
								<!--time-->
								<div class="msg-time">
									<bean:write name="myMsg" property="mDate"/>
									<div style="width: auto; height: 20px; float: right;">
									<logic:notPresent name="umspn" scope="session">
									    <a href="javascript:void(0)" onclick="dodenlu()">forword(<bean:write name="myMsg" property="mfNum"/>)</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<a href="javascript:void(0)" onclick="dodenlu()">hide</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:notPresent>
									<logic:present name="umspn" scope="session">
									<!-- 只有用户登录，并且uid相等时才有删除 -->
									<logic:equal value='${myUser.uId}' name="myMsg" property="user.uId">
										<a href="javascript:void(0)" onclick="doDelete('<bean:write name="myMsg" property="mId"/>',this)">delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:equal>
										<a href="javascript:void(0)" onclick="doForword('<bean:write name="myMsg" property="mId"/>',this)">forword(<bean:write name="myMsg" property="mfNum"/>)</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<logic:notEqual value="1" name="myMsg" property="mhNum">
										<a href="javascript:void(0)" onclick="doHide('${myMsg.mId}',this,'${myUser.uId}','${myMsg.mCon}')">hide</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:notEqual>
									<bean:write name="myMsg" property="mhNum"/>
									<logic:equal value="1" name="myMsg" property="mhNum">
										<a href="javascript:void(0)">hided!</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:equal>
									</logic:present>
									</div>
								</div>
								<!--end#msgtime-->
							</div>
						</div>
						<!--end#msg-->
					</div>
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					<bean:define id="mySCon" name="scon" scope="request"></bean:define>
			 <logic:present name="pagenum" scope="request">
             <logic:greaterThan value="1" name="pagenum"scope="request">
					<div id="fenye">
					<a href="search.do?type=neirong&type2=up&page=
					<logic:present name="page" scope="request">
					<bean:write name="page" scope="request"/>
					</logic:present>
					<logic:notPresent name="page" scope="request">1</logic:notPresent>
					&scan=${mySCon}">
					上页
					</a>
					&nbsp;&nbsp;
					<a href="search.do?type=neirong&type2=down&page=
					<logic:present name="page" scope="request">
					<bean:write name="page" scope="request"/>
					</logic:present>
					<logic:notPresent name="page" scope="request">1</logic:notPresent>
					&scan=${mySCon}">
					下页
					</a>
					</div>
			</logic:greaterThan>
           </logic:present>
				</div>
      <!--search消息结束-->
    </div>
    <!--左边结束-->
    <!--右边-->
    <div id="main-right">
      <div id="main-right-top">
      <logic:present name="umspn" scope="session">
        <!--图片-->
        <div id="rightimg"><img width="70" height="70" src="${myUser.uImg }"/></div>
        <!--图片结束-->
        <div style="height: 5px;">&nbsp;</div>
        <!--姓名-->
        <div id="rightname" style="margin-left: 80px;">
          &nbsp;&nbsp;姓名：<a href="login.do">${myUser.uName }</a><br />
          &nbsp;&nbsp;积分：${myUser.jNum.num }<br />
          &nbsp;&nbsp;等级：待定</div>
        <!--姓名结束-->
        <!--数据相关-->
        <div id="redata">
          <div >
            <h3 id="vfownum">${myUser.fowNum }</h3>
            <a href="#"><b style="color:#C60;">关注</b></a></div>
          <div >
            <h3>${myUser.fowedNum }</h3>
            <a href="#"><b style="color:#939;">粉丝</b></a></div>
          <div>
            <h3 id="mnum">${myUser.mNum }</h3>
            <a href="#"><b style="color:#3C3;">微博</b></a></div>
        </div>
        <!--数据相关结束-->
        <!--消息有关信息-->
        <div id="remsg">
          <ul>
            <li><a href="#">我的收藏&nbsp;&nbsp;&nbsp;</a></li>
            <li><a href="#">我的转发(${myUser.forNum })</a></li>
            <li><a href="#">我的话题(${myUser.huaNum })</a></li>
          </ul>
        </div>
        <!--消息有关信息结束-->
        <!--推荐区-->
        <div>@</div>
        <!--推荐区结束-->
        </logic:present>
      </div> 
    </div>
    <!--右边结束 -->
  </div>
  <div style="font: 0px/0px sans-serif;clear: both;display: block"></div>
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
</body>
</html:html>
