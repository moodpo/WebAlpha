
window.onload=function(){
	startmarquee();
}
function startmarquee(){
//alert('adsfa');
	var gd=120;
	var speed=10;
	var delay=3000;
	var t;
	var p=false;
	var so=window.document.getElementById('scrollmsg');
	var so2=window.document.getElementById('demo');
	so2.innerHTML=so2.innerHTML+so2.innerHTML;
	so.onmouseover=function(){p=true}
    so.onmouseout=function(){p=false}
    so.scrollTop = 0;
    function start() {
    	t=setInterval(scrolling,speed);
		if(!p) 
		so.scrollTop=so.scrollTop+2;
	}
	function scrolling()
	{
		if(so.scrollTop%gd!=0) {
			so.scrollTop=so.scrollTop+2;
			if(so.scrollTop>=so.scrollHeight/2) 
				so.scrollTop = 0;
		} else {
			clearInterval(t);
			setTimeout(start,delay);
		}
	}
	setTimeout(start,delay);
}
