// JavaScript Document
//登陆检测
function clearuEmail(){
  	window.document.getElementById("email").value="";
}
function clearuPW(){
  	window.document.getElementById("pw").value="";
}
function docheck(){
	var uEmail=window.document.getElementById("email").value;
  	var uPW=window.document.getElementById("pw").value;
	if(uEmail=="请输入邮箱地址..." || uEmail==""|| uEmail=="邮箱地址为空！")
	{
		window.document.getElementById("email").value="邮箱地址为空！";	
		return false;
	}
	if(uPW=="请输入密码..." || uPW=="" || uPW=="密码为空！" )
	{
		window.document.getElementById("pw").value="密码为空！";
		return false;
	}
	return true;
}
//搜索检查
function searcheck(){
	var keychar=window.document.getElementById("scon").value;
	if(keychar=="请输入关键字..." || keychar=="" || keychar=="关键字为空！"){
		window.document.getElementById("scon").value="关键字为空！";
		return false;
	}
	return true;
  }
function clearsearch(){
	window.document.getElementById("scon").value="";
  }

function dodenlu(){
	window.document.getElementById('light').style.display='block';
	window.document.getElementById('fade').style.display='block';
}
function closedenlu(){
	document.getElementById('light').style.display='none';
	document.getElementById('fade').style.display='none'
}

