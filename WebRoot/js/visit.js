
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

var obj=null;
function doDelete(mid,objtemp){
	//alert(mid);
	obj=objtemp;
	createXHR();
	var url="delete.do?mid="+mid+"&date="+new Date().toString();
	xhr.open("GET",url);
	xhr.onreadystatechange=showdata2;
	xhr.send(null);
}
function showdata2(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			obj.parentNode.parentNode.parentNode.parentNode.style.display="none";
			mnum.innerHTML=parseInt(mnum.innerHTML)-1;
			vmnum.innerHTML=parseInt(vmnum.innerHTML)-1;
		}
    }
}
var uidTemp1;
var vuidTemp1;
function doFollow(uid,vuid){
	createXHR();
	uidTemp1=uid;
	vuidTemp1=vuid;
	var url="follow.do?uid="+uid+"&vuid="+vuid;
	xhr.open("GET",url);
	xhr.onreadystatechange=showdata3;
	xhr.send(null);
}
function showdata3(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			vfollow.innerHTML='<a href="javascript:void(0)" style="background-color:#CCC;">加关注</a>  '+
			'<a href="javascript:void(0)" onClick="doUnFollow('+uidTemp1+','+vuidTemp1+')">取消关注</a>';
			vfowednum.innerHTML=parseInt(vfowednum.innerHTML)+1;
			vfownum.innerHTML=parseInt(vfownum.innerHTML)+1;
		}
    }
}
var uidTemp2;
var vuidTemp2;
function doUnFollow(uid,vuid){
	createXHR();
	uidTemp2=uid;
	vuidTemp2=vuid;
	var url="unFollow.do?uid="+uid+"&vuid="+vuid;
	xhr.open("GET",url);
	xhr.onreadystatechange=showdata4;
	xhr.send(null);
}
function showdata4(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			vfollow.innerHTML='<a href="javascript:void(0)" onClick="doUnFollow('+uidTemp2+','+vuidTemp2+')">加关注</a>  '+
			'<a href="javascript:void(0)" style="background-color:#CCC;" >取消关注</a>';
			vfowednum.innerHTML=parseInt(vfowednum.innerHTML)-1;
			vfownum.innerHTML=parseInt(vfownum.innerHTML)-1;
		}
    }
}
var obj3=null;
function doHide(mid,objh,uid,mcon){
	//alert(mid);
	alert(uid);
	alert(mcon);
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