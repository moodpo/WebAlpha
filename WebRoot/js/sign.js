// JavaScript Document
function disuName(){
  	prouemail.innerHTML=""
	prouname.innerHTML="这将是你的昵称！";
	proupw.innerHTML="";
	proucpw.innerHTML="";
	procode.innerHTML="";
  }
  function disuPW(){
	prouemail.innerHTML=""
	prouname.innerHTML="";
	proupw.innerHTML="密码由6-16位数字和英文字母组成！";
	proucpw.innerHTML="";
	procode.innerHTML="";
  }
  function disucPW(){
	prouemail.innerHTML=""
	prouname.innerHTML="";
	proupw.innerHTML="";
	proucpw.innerHTML="这里你需要重复一下密码！";
	procode.innerHTML="";
  }
  function disuEmail(){
  	prouemail.innerHTML="请输入你的常用邮箱，此邮箱将用于激活你的帐号！"
	prouname.innerHTML="";
	proupw.innerHTML="";
	proucpw.innerHTML="";
	procode.innerHTML="";
  }
 function changeImg()
  {    
  	document.getElementById("code").src=Math.round(Math.random()*10000)+".Code.do";
  }
 function signCheck(){
	var suEmail=window.document.getElementById("uemail").value;
	var suName=window.document.getElementById("uname").value;
	var suPW=window.document.getElementById("upw").value;
	var sucPW=window.document.getElementById("ucpw").value;
	var chcode=window.document.getElementById("ucode").value;
	if(suEmail.indexOf("@")==0 || suEmail.indexOf("@")==suEmail.length-1 || suEmail.indexOf("@")==-1 || suEmail.indexOf("@")!=                          suEmail.lastIndexOf("@")){
		prouemail.innerHTML="邮箱格式错误！";
		return false;
	}
	if(suName==""){
	  
		prouname.innerHTML="用户名为空！";
		prouemail.innerHTML="";
		return false;
	}
	if(suPW=="" || suPW.length>16 || suPW.length<6){
	  
		proupw.innerHTML="密码为空或密码位数不在规定范围中！";
        prouemail.innerHTML="";
	    prouname.innerHTML="";
		return false;
	}
	if(sucPW!=suPW){
	   
		proucpw.innerHTML="两次密码不相同！";
		prouemail.innerHTML="";
		prouname.innerHTML="";
		proupw.innerHTML="";
		return false;
	}
	if(chcode=="" || chcode.length!=4){
	    
		procode.innerHTML="验证码不正确";
		proucpw.innerHTML="";
		prouemail.innerHTML="";
		prouname.innerHTML="";
		proupw.innerHTML="";
		return false;
	}
	return true;
}