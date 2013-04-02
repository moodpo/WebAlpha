<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
	<html:base />
	<title>小邪微博&nbsp;|&nbsp;我的首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pub.css" />
	<link rel="stylesheet" type="text/css" href="css/mypage.css" />
	<script src="js/pub.js">
	
</script>
	<script src="js/prochat.js">
	
</script>
	<script src="js/mypage.js">
	
</script>
	<script type="text/javascript" src="js/slider.js"></script>
</head>
<body>
	<!-- 微博转发 -->
	<div id="light" class="zong">
	  <p style="margin:2px 0;"><b>微博转发：</b></p>
	  <div id="forcontent">
	    <form method="post" onSubmit="return doForword()" id="form-forword">
	      <textarea name="forword_con" id="forword_con" rows="10">转发微博。</textarea>
	      <input type="submit" value="转发" id="sub-for"/>
	      &nbsp;&nbsp;
	      <input type="reset" value="清除" id="res-for"/>
	    </form>
	  </div>
	  <div id="tishi_for"><a href="javascript:void(0)" onClick="closeZF()">关闭</a></div>
	</div>
	<div id="zhuanfa" class="fugai"></div>
	<!-- 微博转发结束 -->
	<!--上部边栏-->
	<div id="sidebartop">
		<div id="logo">
			<!--logo-->
			<div id="logos">
				<img src="image/logo.jpg" />
			</div>
			<!--end logo-->
			<!--导航栏-->
			<div>
				<div id="daohang">
					<ul>
						<li>
							<a href="login.do" style="background-color: #FFF; color: #000">我的首页</a>
						</li>
						<li>
							<a href="huati.do">话题</a>
						</li>
						<li>
							<a href="guangbo.do">广播</a>
						</li>
						<li>
							<a href="visit.do">浏览</a>
						</li>
						<li>
							<a href="about.jsp">关于</a>
						</li>
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
						<li>
							<a href="config.jsp">设置</a>
						</li>
						<li>
							<a href="javascript:void(0)">帮助</a>
						</li>
						<li>
							<a href="javascript:void(0)">邀请好友</a>
						</li>
						<logic:present name="umspn" scope="session">
					<logic:notEmpty name="umspn" scope="session">
					<bean:define id="myUser" name="umspn" scope="session" property="user"></bean:define>
					   <logic:equal value="3" name="myUser" property="uId">
						<li>
							<a href="edit.jsp">编辑精选</a>
					    </li>
					   </logic:equal>
					</logic:notEmpty>
					</logic:present>
						<li>
							<a href="logout.do">退出</a>
						</li>
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
			<!--左边-->
			<div id="main-left">
				<!--发布-->
				<div id="fabu-div">
					<form id="form_fabu" onsubmit="return doFaBu();">
						<input type="hidden" id="fabu_uid" name="fabu_uid" value="<bean:write name="myUser" property="uId"/>">
						<div id="fabu-div-div">
							<textarea style="width: 97%" rows="6" id="fabu_content"
								name="fabu_content" onclick='window.document.getElementById("fabu_content").value="";'>小邪微博，记录生活......</textarea>
						</div>
						<div id="fabu-tishi">
							<span id="proword">还可以输入<span id="stat_left"
								class="b light"></span>字</span>
							<input type="submit" value="发布"
								style="width: 60px; height: 25px;" />
						</div>
					</form>
				</div>
				<!--发布结束-->
				<!-- 消息开始  -->

				<div id="namecon"></div>
				<div id="oldcon">
				<logic:present name="umspn" scope="session">
				<logic:notEmpty name="umspn" scope="session">
				<logic:notEmpty name="umspn" scope="session" property="msgSet">
				<bean:define id="myMsgSet" name="umspn" scope="session" property="msgSet"></bean:define>
				<logic:iterate id="myMsg" name="myMsgSet">
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
									<a href='visit.do?vuid=<bean:write name="myMsg" property="user.uId"/>'><bean:write name="myMsg" property="user.uName"/></a>: <bean:write name="myMsg" property="mCon" filter="false"/>
								</div>
								<!--end#msgandname-->
								<!--time-->
								<div class="msg-time">
									<bean:write name="myMsg" property="mDate"/>
									<div style="width: auto; height: 20px; float: right;">
									<logic:equal value='${myUser.uId}' name="myMsg" property="user.uId">
										<a href="javascript:void(0)" onclick="doDelete('<bean:write name="myMsg" property="mId"/>',this)">delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:equal>
										<a href="javascript:void(0)" onclick="doZF('<bean:write name="myMsg" property="mId"/>',this,'<bean:write name="myMsg" property="user.uId"/>','<bean:write name="myMsg" property="mCon" filter="false"/>','<bean:write name="myMsg" property="user.uName"/>')">forword(<span><bean:write name="myMsg" property="mfNum"/></span>)</a>&nbsp;&nbsp;&nbsp;&nbsp;
									<logic:equal value="1" name="myMsg" property="mhNum">
									    <a href="javascript:void(0)">hided!</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:equal>
									<logic:notEqual value="1" name="myMsg" property="mhNum">
										<a href="javascript:void(0)" onclick="doHide('<bean:write name="myMsg" property="mId"/>',this,'${myUser.uId}','${myMsg.mCon }')">hide</a>&nbsp;&nbsp;&nbsp;&nbsp;
									</logic:notEqual>
									</div>
								</div>
								<!--end#msgtime-->
							</div>
						</div>
						<!--end#msg-->
					</div>
					</logic:iterate>
					</logic:notEmpty>
					</logic:notEmpty>
					</logic:present>
					<!-- 分页 -->
					<logic:greaterThan value="1" name="umspn" property="pageNum" scope="session">
					<div>
					<a href="getNext.do?type=up&page=
					<logic:present name="page" scope="session">
					<bean:write name="page" scope="session"/>
					</logic:present>
					<logic:notPresent name="page" scope="session">1</logic:notPresent>
					">上页</a>
					&nbsp;&nbsp;
					<a href="getNext.do?type=down&page=
					<logic:present name="page" scope="session">
					<bean:write name="page" scope="session"/>
					</logic:present>
					<logic:notPresent name="page" scope="session">1</logic:notPresent>
					">下页</a></div>
					</logic:greaterThan>
					<logic:present name="pageTishi" scope="request">
					<bean:write name="pageTishi" scope="request"/>
					</logic:present>
				</div>
				<!-- 消息结束 -->
			</div>
			<!--左边结束-->
			<!--右边-->
			<div id="main-right">
				<div id="main-right-top">
					<!--图片-->
					<div id="rightimg">
						<img id="imguse" width="70" height="70" src='<bean:write name="myUser" property="uImg"/>' />
					</div>
					<!--图片结束-->
					<!--姓名-->
					<div>
						&nbsp;
					</div>
					<div id="rightname" style="margin-left: 80px;">
						&nbsp;&nbsp;姓名:<a id="nameuse" href="login.do"><bean:write name="myUser" property="uName"/></a>
						<br />
						&nbsp;&nbsp;积分:<bean:write name="myUser" property="jNum.num"/>
						<br />
						&nbsp;&nbsp;等级:未定
					</div>
					<!--姓名结束-->
					<!--数据相关-->
					<br />
					<div id="redata">
						<div>
							<h3><bean:write name="myUser" property="fowNum"/></h3>
							<a href="#"><b style="color: #C60;">关注</b> </a>
						</div>
						<div>
							<h3><bean:write name="myUser" property="fowedNum"/></h3>
							<a href="#"><b style="color: #939;">粉丝</b> </a>
						</div>
						<div>
							<h3 id="mnum"><bean:write name="myUser" property="mNum"/></h3>
							<a href="#"><b style="color: #3C3;">微博</b> </a>
						</div>
					</div>
					<!--数据相关结束-->
					<!--消息有关信息-->
					<div id="remsg">
						<ul>
							<li>
								<a href="#">我的收藏&nbsp;&nbsp;&nbsp;</a>
							</li>
							<li>
								<a href="#">我的转发(<span id="ufornum"><bean:write name="myUser" property="forNum"/></span>)</a>
							</li>
							<li>
								<a href="#">我的话题(<span id="uhuanum"><bean:write name="myUser" property="huaNum"/></span>)</a>
							</li>
						</ul>
					</div>
					<!--消息有关信息结束-->
					<!--推荐区-->
					<div>
						<b style="color: gray;">推荐区</b>
					</div>
					<!--推荐区结束-->
				</div>
			</div>
		</div>
		<!--右边结束-->
	</div>
	<div style="font: 0px/ 0px sans-serif; clear: both; display: block"></div>
	<!--中间内容结束-->
	<!--内容结束-->
	<!--底部边栏-->
	<div id="sidebarbottom">
		<ul>
			<li>
				<a href="javascript:void(0)">关于我们</a>
			</li>
			<li>
				<a href="#">联系我们</a>
			</li>
			<li>
				<a href="#">使用协议</a>
			</li>
			<li>
				<a href="#">隐私条款</a>
			</li>
			<li>
				<a href="#">加入我们</a>
			</li>
			<li>
				<a href="#">帮助</a>
			</li>
			<li>
				<a href="#">京ICP100001</a>
			</li>
		</ul>
	</div>
	<!--底部边栏结束-->
	<script>
	var topslider = new slider('namecon', 2, 130, 630, 20, 2, 20);
</script>
</body>
