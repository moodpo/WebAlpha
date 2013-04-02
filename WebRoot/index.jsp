<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>小邪微博&nbsp;|&nbsp;首页</title>
<meta http-equiv="pragma" content="no-cache">
<link rel="stylesheet" type="text/css" href="css/pub.css"/>
<link rel="stylesheet" type="text/css" href="css/index.css"/>
<script src="js/pub.js"></script>
<script src="js/index.js"></script>
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
          <li><a href="start.do" style="background-color:#FFF; color:#000">首页</a></li>
          <li><a href="huati.do">话题</a></li>
          <li><a href="guangbo.do">广播</a></li>
          <li><a href="visit.do">浏览</a></li>
          <li><a href="about.jsp">关于</a></li>
        </ul>
      </div>
      <div id="daohang2">
        <ul>
          <li><a href="javascript:void(0)" onClick="dodenlu()">登录</a></li>
          <li><a href="sign.jsp">注册</a></li>
          <li><a href="help.jsp">帮助</a></li>
          <li><a href="javascript:void(0)">邀请好友</a></li>
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
    <!--话题部分-->
    <div id="huati">
      <!--左边-->
      <div id="huati-left">
        <h2><a href="search.do?type=huati&scon=盛大">盛大游戏布局移动平台称投入可观研发费用</a></h2>
        <p style=" color: #666;">10月21日下午消息，盛大游戏董事长兼CEO谭群钊今日透露，该公司很看好游戏在移动平台的机会，已经投入了“可观研发费用”，但未透露具体比例。
        第八届中国国际网络文化博览会(简称“网博会”)今日在北京开幕。谭群钊在开幕式上说，网游行业有三个创新的方向，分别是游戏类型多元化、平台多元化及区域多元化(指国际化)，这些方向将会带来网游行业走进下一轮高速增长。
        对于平台多元化，谭群钊在今日下午接受网易科技专访时进一步解释说，这些平台包括移动终端(iPhone、iPad、Android)、社交游戏、机顶盒平台等，
        盛大游戏在这些平台...
        <a href="search.do?type=huati&scon=盛大">【#盛大#】查看详情(话题关注度+10)</a></p> 
      </div>
      <!--左边结束-->
      <!--右边-->
      <div id="huati-right">
        <div id="signimg">
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <div style="margin:15px; font-size:15px; font-weight:300;">
            <p>说说身边事情，聊聊新知新闻，交换思想，理性交锋，共同探求事物本质。传递信息，关注达人，我们一起来微博。</p>
            <div id="clicksign">
             <input type="button" value="点击注册" onclick="window.location.assign('sign.jsp');"/>
            </div>
          </div>
        </div>
      </div>
      <!--右边结束-->
    </div>
    <!--话题部分结束-->
    <!--滚动消息-->
    <div id="scrollmsg">
      <div style="width:630px; padding:10px;" id="demo">
        <logic:present name="nms" scope="session">
        <logic:notEmpty name="nms" scope="session">
        <logic:iterate id="myMsg" name="nms" scope="session">
          <!--msg 8条-->
          <div class="msg">
            <!--img-->
            <div class="msg-img"><img width="80" height="80" src='<bean:write name="myMsg" property="user.uImg"/>'/></div>
            <!--end img-->
            <div  class="msgandname">
              <!--msgandname-->
              <div  class="msgandname_c"><a href='visit.do?vuid=<bean:write name="myMsg" property="user.uId"/>' style="text-decoration: none;"><bean:write name="myMsg" property="user.uName"/></a>
                <b>：</b><bean:write name="myMsg" property="mCon" filter="false"/>
              </div>
              <!--end#msgandname-->
              <!--time-->
              <div  class="msg-time">
                <bean:write name="myMsg" property="mDate"/>
              </div>
              <!--end#msgtime-->
            </div>
          </div>
          <!--end#msg-->
        </logic:iterate>
        </logic:notEmpty>
        </logic:present>
      </div>
    </div>
    <!--滚动消息结束-->
    <!--微博达人-->
    <div id="weibotop10">
      <!--#daren9-->
      <div style="height: 5px;"></div>
      <div id="daren-title">微博达人</div>
      <logic:present name="tus" scope="session">
      <logic:notEmpty name="tus" scope="session">
      <logic:iterate id="myUser" name="tus" scope="session"><a href='visit.do?vuid=<bean:write name="myUser" property="uId"/>'>
      <img id="daren" src='<bean:write name="myUser" property="uImg"/>'/></a>
      </logic:iterate>
      </logic:notEmpty>
      <!--end#daren-->
      <!--#more-->
      <div id="more"><a href="guangbo.do">更多</a></div>
      </logic:present>
      <!--end#more-->
    </div>
    <!--微博达人结束-->
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
</html>
