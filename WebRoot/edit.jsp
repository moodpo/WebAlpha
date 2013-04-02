<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html lang="true">
<head>
	<html:base />

	<title>小邪微博&nbsp;|&nbsp;编辑添加内容</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/pub.css" />
	<script src="js/pub.js"></script>
	<script type="text/javascript" src="plus/jscripts/tiny_mce/tiny_mce.js"></script>
	<style>
#main-left {
	width: 800px;
	height: 900px;
	float: left;
	margin: 0;
	background-color: #FFF;
	text-align: center;
	padding-top: 3px;
}
</style>
</head>
<script type="text/javascript">
	tinyMCE.init( {
				// General options
				mode : "textareas",
				theme : "advanced",
				plugins : "pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",

				// Theme options
				theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
				theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
				theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
				theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
				theme_advanced_toolbar_location : "top",
				theme_advanced_toolbar_align : "left",
				theme_advanced_statusbar_location : "bottom",
				theme_advanced_resizing : true,

				// Example content CSS (should be your site CSS)
				content_css : "css/content.css",

				// Drop lists for link/image/media/template dialogs
				template_external_list_url : "lists/template_list.js",
				external_link_list_url : "lists/link_list.js",
				external_image_list_url : "lists/image_list.js",
				media_external_list_url : "lists/media_list.js",

				// Style formats
				style_formats : [ {
					title : 'Bold text',
					inline : 'b'
				}, {
					title : 'Red text',
					inline : 'span',
					styles : {
						color : '#ff0000'
					}
				}, {
					title : 'Red header',
					block : 'h1',
					styles : {
						color : '#ff0000'
					}
				}, {
					title : 'Example 1',
					inline : 'span',
					classes : 'example1'
				}, {
					title : 'Example 2',
					inline : 'span',
					classes : 'example2'
				}, {
					title : 'Table styles'
				}, {
					title : 'Table row 1',
					selector : 'tr',
					classes : 'tablerow1'
				} ],

				// Replace values for the template plugin
				template_replace_values : {
					username : "Some User",
					staffid : "991234"
				}
			});
</script>
<body>
	<!--上部边栏-->
	<div id="sidebartop">
		<div id="logo">
			<!--logo-->
			<div id="logos" onclick="javascript: void (0)">
				<img src="image/logo.jpg" />
			</div>
			<!--end logo-->
			<!--导航栏-->
			<div>
				<div id="daohang">
					<ul>
						<li>
							<a href="login.do" style="background-color: #FFF; color: #000">管理首页</a>
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
			<div id="main-left">
				<div>
					&nbsp;
				</div>
				<div id="edit-title">
					<h3>
						编辑添加内容
					</h3>
				</div>
				<!--编辑器  -->
				<form action="edit.do" onsubmit="doEditCheck()" method="post">
					<div id="hua-title">
						话题题目：
						<input type="text" id="htitle" name="htitle" style="width: 400px; height: 25px;">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<br/>
					<div id="hua-content" align="center">
						<textarea id="elm1" name="elm1" rows="40" cols="80" style="width: 80%">
                        </textarea>
					</div>
					<input type="submit" value="提交">
					&nbsp;&nbsp;
					<input type="reset" value="清除">
					&nbsp;&nbsp;
				</form>
				<!--编辑器结束 -->
			</div>
		</div>
		<!--中间内容结束-->
		<div style="font: 0px/ 0px sans-serif; clear: both; display: block">
		</div>
	</div>
	<!--内容结束-->
	<!--底部边栏-->
	<div id="sidebarbottom">
		<ul>
			<li>
				<a href="#">关于我们</a>
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
</body>
</html:html>
