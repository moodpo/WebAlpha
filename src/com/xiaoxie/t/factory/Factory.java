package com.xiaoxie.t.factory;

import com.xiaoxie.t.daoimp.FollowImp;
import com.xiaoxie.t.daoimp.ForwordImp;
import com.xiaoxie.t.daoimp.HideImp;
import com.xiaoxie.t.daoimp.HuaTiImp;
import com.xiaoxie.t.daoimp.HuaexImp;
import com.xiaoxie.t.daoimp.JiFenImp;
import com.xiaoxie.t.daoimp.MsgImp;
import com.xiaoxie.t.daoimp.UConfigImp;
import com.xiaoxie.t.daoimp.UrlImp;
import com.xiaoxie.t.daoimp.UsersImp;
import com.xiaoxie.t.daoinface.IFollow;
import com.xiaoxie.t.daoinface.IForword;
import com.xiaoxie.t.daoinface.IHide;
import com.xiaoxie.t.daoinface.IHuaTi;
import com.xiaoxie.t.daoinface.IHuaex;
import com.xiaoxie.t.daoinface.IJiFen;
import com.xiaoxie.t.daoinface.IMsg;
import com.xiaoxie.t.daoinface.IUConfig;
import com.xiaoxie.t.daoinface.IUrl;
import com.xiaoxie.t.daoinface.IUsers;

public class Factory {
	public static IFollow getFollowImp(){
		return FollowImp.getFollowImp();
	}
	public static IForword getForwordImp(){
		return ForwordImp.getForwordImp();
	}
	public static IHide getHideImp(){
		return HideImp.getHideImp();
	}
	public static IHuaTi getHuaTiImp(){
		return HuaTiImp.getHuaTiImp();
	}
	public static IJiFen getJiFenImp(){
		return JiFenImp.getJiFenImp();
	}
	public static IMsg getMsgImp(){
		return MsgImp.getMessagesImp();
	}
	public static IUConfig getUConfigImp(){
		return UConfigImp.getUConfigImp();
	}
	public static IUrl getUrlImp(){
		return UrlImp.getUrlImp();
	}
	public static IUsers getUsersImp(){
		return UsersImp.getUsersImp();
	}
	public static IHuaex getHuaexImp(){
		return HuaexImp.getInstance();
	}
}
