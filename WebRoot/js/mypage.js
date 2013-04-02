var xhr;
function createXHR(){
    	if(window.XMLHttpRequest){
			xhr=new XMLHttpRequest();
		}
		else{
			if(window.ActiveXObject){
				xhr=new ActiveXObject("Microsoft.xmlhttp");
			}
		}
    }

//消息发布
var fabuuid;
var fabumsg;
function doFaBu(){
	var uid=window.document.getElementById("fabu_uid").value;
	var msg=window.document.getElementById("fabu_content").value;
	msg=msg.replace(/#/g,'＃');
	fabuuid=uid;
	fabumsg=msg;
    	createXHR();
    	if(msg==""){
			return false;
	    }
    	var url="fabu.do?msg="+msg+"&uid="+uid+"&date="+new Date().toString();
    	xhr.open("GET",url);
    	xhr.onreadystatechange=showdata;
    	xhr.send(null);
    	return false;
    }
function showdata(){
    	if(xhr.readyState==4){
    		if(xhr.status==200){
    			//构建表面图形数据
    			var doc=xhr.responseXML;
    			var mid=doc.getElementsByTagName("msgid")[0].childNodes[0].nodeValue;
    			var content=doc.getElementsByTagName("msgcon")[0].childNodes[0].nodeValue;
    			var surl;
    			//alert(doc.getElementsByTagName("msgsurl")[0].childNodes[0]);
    			if(doc.getElementsByTagName("msgsurl")[0].childNodes[0]!=undefined){
    				surl=doc.getElementsByTagName("msgsurl")[0].childNodes[0].nodeValue;
    				//alert(content);
    			}
    			//var surl=doc.getElementsByTagName("msgsurl")[0].childNodes[0].nodeValue;
    			//alert(doc.getElementsByTagName("msgsurl")[0].childNodes[0]);
    			if(content.indexOf("＃")!=content.lastIndexOf("＃")){
    				
    				var hua=content.substring(content.indexOf("＃")+1,content.lastIndexOf("＃"));
    				
    				content=content.substring(0,content.indexOf("＃"))+"#<a href='search.do?type=huati&scon="+hua+"'>"+hua+"</a>#"+content.substring(content.lastIndexOf("＃")+1,content.length);
    			
    				//alert(content);
    			}
    			
    			var ncon=window.document.getElementById("imguse").src.toString();
    			var nameuse=window.document.getElementById("nameuse").innerHTML;
    			//alter(content);
    			fabumsg='"'+fabumsg+'"';
    			//nameuse='"'+nameuse+'"';
    			var con="<div style='width:630px; margin:0 auto;'>";
    			con+="<div class='msg'><div style='height: 10px;'></div>";
    			con+="<div class='msg-img'>";
    			con+="<img width='60' height='60' src='";
    			con+=ncon;
    			con+="'/></div><div class='msgandname'>";
    			con+="<div class='msgandname_c'>";
    			con+="<a href='";
    			con+="visit.do?vmid="+mid;
    			con+="'>";
    			con+=nameuse;
    			con+="</a>：";
    			con+=content;
    			con+="</div><div class='msg-time'>10 min ago";
    			con+="<div style='width: auto; height: 20px; float: right;'>";
    			con+="<a href='javascript:void(0)' onclick='doDelete("+mid+",this)'>delete</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    			con+="<a href='javascript:void(0)' onclick='doZF("+mid+",this,"+fabuuid+","+fabumsg+","+nameuse+")'>forword(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    			con+="<a href='javascript:void(0)' onclick='doHide("+mid+",this)'>hide(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    			con+="</div></div></div></div></div>";

    			var oldcon=window.document.getElementById("oldcon").innerHTML;
    			
//    			在IE下才会起作用
//    			var namecon=window.document.getElementById("namecon");
//    			window.document.getElementById("oldcon").innerHTML=namecon.innerHTML+oldcon;
//    			window.document.getElementById("namecon").innerHTML=con;
//    			topslider.show();
    			
    			window.document.getElementById("oldcon").innerHTML=con+oldcon;
    			
    			window.document.getElementById("fabu_content").value="";
    			mnum.innerHTML=parseInt(mnum.innerHTML)+1;
    		}
    	}
    }

//发布的测试
function doFaBuTemp(){
	alert("doadsl");
	var ncon=window.document.getElementById("imguse").src.toString();
	var nameuse=window.document.getElementById("nameuse").href.toString();
	var nameuse=window.document.getElementById("nameuse").innerHTML;
	var content=window.document.getElementById("fabu_content").value;
	
	var con="<div style='width:630px; margin:0;'>";
	con+="<div class='msg'>";
	con+="<div class='msg-img'>";
	con+="<img src='";
	con+=ncon
	con+="'/></div><div class='msgandname'>";
	con+="<div class='msgandname_c'>";
	con+="<a href='";
	con+=nameuse
	con+="'>";
	con+=nameuse
	con+="</a>:";
	con+=content
	con+="</div><div class='msg-time'>10 min ago";
	con+="<div style='width: auto; height: 20px; float: right;'>";
	con+="<a href='javascript:void(0)' onclick='dodelete()'>delete</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	con+="<a href='javascript:void(0)' onclick='doforword()'>forword(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	con+="<a href='javascript:void(0)' onclick='dohide()'>hide(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
	con+="</div></div></div></div></div>";

	var oldcon=window.document.getElementById("oldcon").innerHTML;
	window.document.getElementById("oldcon").innerHTML=con+oldcon;
	return false;
}

//消息删除
var objtemp=null;
function doDelete(mid,obj){
	//alert(mid);
	objtemp=obj;
	createXHR();
	var url="delete.do?mid="+mid+"&date="+new Date().toString();
	var midTemp=mid;
	xhr.open("GET",url);
	xhr.onreadystatechange=showdata2;
	xhr.send(null);
}
function showdata2(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			objtemp.parentNode.parentNode.parentNode.parentNode.style.display="none";
			mnum.innerHTML=parseInt(mnum.innerHTML)-1;
		}
    }
}

//消息转发
var obj2=null;
var formid;
var msguid;
var formcon;
var forcon;
var formuname;
function doZF(mid,objf,uid,mcon,muname){
	obj2=objf;
	formid=mid;
	msguid=uid;
	formcon=mcon;
	formuname=muname;
	window.document.getElementById('light').style.display='block';
	window.document.getElementById('zhuanfa').style.display='block';
}
function closeZF(){
	document.getElementById('light').style.display='none';
	document.getElementById('zhuanfa').style.display='none'
}
function doForword(){
	forcon=window.document.getElementById("forword_con").value;
	createXHR();
	if(forcon==""){
		return false;
    }
	var url="forword.do?forcon="+forcon+"&mid="+formid+"&msguid="+msguid+"&mcon="+formcon+"&date="+new Date().toString();
	xhr.open("GET",url);
	xhr.onreadystatechange=showforword;
	xhr.send(null);
	return false;
}
function showforword(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			//alert(obj2.childNodes[0].innerHTML);
			//消息id
			var msid=xhr.responseText;
			//图片地址
			var ncon=window.document.getElementById("imguse").src.toString();
			//名字
			var nameuse=window.document.getElementById("nameuse").innerHTML;
			//内容
			var content=forcon+"<a href=visit.do?vuid="+msguid+">@"+formuname+"</a>:"+formcon;
			//转发者的id
			//alert("do");
			
			formcon='"'+formcon+'"';
			formuname='"'+formuname+'"';
			var con="<div style='width:630px; margin:0 auto;'>";
			con+="<div class='msg'><div style='height: 10px;'></div>";
			con+="<div class='msg-img'>";
			con+="<img width='60' height='60' src='";
			con+=ncon;
			con+="'/></div><div class='msgandname'>";
			con+="<div class='msgandname_c'>";
			con+="<a href='";
			con+="visit.do?vmid="+msid;
			con+="'>";
			con+=nameuse;
			con+="</a>:";
			con+=content;
			con+="</div><div class='msg-time'>10 min ago";
			con+="<div style='width: auto; height: 20px; float: right;'>";
			con+="<a href='javascript:void(0)' onclick='doDelete("+msid+",this)'>delete</a>&nbsp;&nbsp;&nbsp;&nbsp;";
			con+="<a href='javascript:void(0)' onclick='doZF("+msid+",this,"+msguid+","+formcon+","+formuname+")'>forword(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
			con+="<a href='javascript:void(0)' onclick='doHide("+msid+",this)'>hide(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;";
			con+="</div></div></div></div></div>";
			
			var oldcon=window.document.getElementById("oldcon").innerHTML;
			window.document.getElementById("oldcon").innerHTML=con+oldcon;
			//修改消息的转发数和用户的转方数
			closeZF();
			obj2.childNodes[0].innerHTML=parseInt(obj2.childNodes[0].innerHTML)+1;
			ufornum.innerHTML=parseInt(ufornum.innerHTML)+1;
			mnum.innerHTML=parseInt(mnum.innerHTML)+1;
			//alert("<a href='javascript:void(0)' onclick='doForword("+msid+",this,"+msguid+","+formcon+","+formuname+")'>forword(0)</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		}
	}
}
var obj3;
function doHide(mid,objh,uid,mcon){
	obj3=objh;
	if(objh.innerHTML!="hide")
		return false;
	createXHR();
	var url="hide.do?mid="+mid+"&uid="+uid+"&mcon="+mcon+"&date="+new Date().toString();
	var midTemp=mid;
	xhr.open("GET",url);
	xhr.onreadystatechange=showhide;
	xhr.send(null);
}
function showhide(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			obj3.innerHTML="hided!";
			obj3.parentNode.innerHTML=obj3.parentNode.innerHTML+"&nbsp;&nbsp;&nbsp;&nbsp;";
		}
    }
}




























