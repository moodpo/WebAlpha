// JavaScript Document
// 这里都是公用函数，挺多的...
// 获取元素  
var  $ = function(element) {  
  return (typeof(element) == 'object' ? element : document.getElementById(element));  
},  
// 判断浏览器  
brower = function() {  
  var ua = navigator.userAgent.toLowerCase();  
  var os = new Object();  
  os.isFirefox = ua.indexOf ('gecko') != -1;  
  os.isOpera = ua.indexOf ('opera') != -1;  
  os.isIE = !os.isOpera  &&  ua.indexOf ('msie') != -1;  
  os.isIE7 = os.isIE  &&  ua.indexOf ('7.0') != -1;  
  return os;  
},  
// 事件操作(可保留原有事件)  
eventListeners = [],  
findEventListener = function(node, event, handler){  
  var i;  
  for (i in eventListeners){  
   if (eventListeners[i].node == node  &&  eventListeners[i].event == event  &&  eventListeners[i].handler == handler){  
    return i;  
   }  
  }  
  return null;  
},  
myAddEventListener = function(node, event, handler){  
  if (findEventListener(node, event, handler) != null){  
   return;  
  }  
  if (!node.addEventListener){  
   node.attachEvent('on' + event, handler);  
  }else{  
   node.addEventListener(event, handler, false);  
  }  
  eventListeners.push({node: node, event: event, handler: handler});  
},  
removeEventListenerIndex = function(index){  
  var eventListener = eventListeners[index];  
  delete eventListeners[index];  
  if (!eventListener.node.removeEventListener){  
   eventListener.node.detachEvent('on' + eventListener.event,eventListener.handler);  
  }else{  
   eventListener.node.removeEventListener(eventListener.event,eventListener.handler, false);  
  }  
},  
myRemoveEventListener = function(node, event, handler){  
  var index = findEventListener(node, event, handler);  
  if (index == null) return;  
  removeEventListenerIndex(index);  
},  
cleanupEventListeners = function(){  
  var i;  
  for (i = eventListeners.length; i > 0; i--){  
   if (eventListeners[i] != undefined){  
    removeEventListenerIndex(i);  
   }  
  }  
};  

/*======================================================  
  - statInput 输入限制统计  
  - By Mudoo 2008.5  
  - 长度超出_max的话就截取...貌似没有更好的办法了  
======================================================*/  
function statInput(e, _max, _exp) {  
  e   = $(e);  
  _max  = parseInt(_max);  
  _max  = isNaN(_max) ? 0 : _max;  
  _exp_exp  = _exp==undefined ? {} : _exp;  
    
  if(e==null || _max==0) {  
   alert('statInput初始化失败！');  
   return;  
  }  
    
  var  
  // 浏览器  
  _brower  = brower();  
  // 输出对象  
  _objMax  = _exp._max==undefined ? null : $(_exp._max),  
  _objTotal = _exp._total==undefined ? null : $(_exp._total),  
  _objLeft = _exp._left==undefined ? null : $(_exp._left),  
  // 弹出提示  
  _hint  = _exp._hint==undefined ? null : _exp._hint;  
    
  // 初始统计  
  if(_objMax!=null) _objMax.innerHTML = _max;  
  if(_objTotal!=null) _objTotal.innerHTML = 0;  
  if(_objLeft!=null) _objLeft.innerHTML = 0;  
    
  // 设置监听事件  
  // 输入这个方法比较好.  
  // 但是Opera下中文输入跟粘贴不能正确统计...相当BT的东西...  
  // 如果不考虑Opera的话就用这个吧.否则就老老实实用计时器.  
  if(_brower.isIE) {  
   myAddEventListener(e, "propertychange", stat);  
  }else{  
   myAddEventListener(e, "input", stat);  
  }  
  /*  
  // 用计时器的话就什么浏览器都支持了.  
  var _intDo = null;  
  myAddEventListener(e, "focus", setListen);  
  myAddEventListener(e, "blur", remListen);  
  function setListen() {  
   _intDo = setInterval(stat, 10);  
  }  
  function remListen() {  
   clearInterval(_intDo);  
  }  
  */  
    
  // 统计函数  
  var _len, _olen, _lastRN, _sTop;  
  _olen = _len = 0;  
  function stat() {  
   _len = e.value.length;  
   if(_len==_olen) return;  // 防止用计时器监听时做无谓的牺牲...  
   if(_len>_max) {  
    _sTop = e.scrollTop;  
    // 避免IE最后俩字符为'\r\n'.导致崩溃...  
    _lastRN = (e.value.substr(_max-1, 2) == "\r\n");  
    e.value = e.value.substr(0, (_lastRN ? _max-1 : _max));  
    if(_hint==true) alert("已超出输入字数.");  
    // 解决FF老是跑回顶部  
    if(_brower.isFirefox) ee.scrollTop = e.scrollHeight;  
   }  
   _olen = _len = e.value.length;  
     
   // 显示已输入字数  
   if(_objTotal!=null) _objTotal.innerHTML = _len;  
   // 显示剩余可输入字数  
   if(_objLeft!=null) _objLeft.innerHTML = (_max-_len)<0 ? 0 : (_max-_len);  
  }  
    
  stat();  
} 

myAddEventListener(window, "load", testStatInput);  
function testStatInput(){  
  statInput('fabu_content', 140, {_max : 'stat_max', _total : 'stat_total', _left : 'stat_left', _hint : false});  
}  