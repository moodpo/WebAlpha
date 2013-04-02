package com.xiaoxie.t.result;

import java.util.List;

import com.xiaoxie.t.domain.Msg;
import com.xiaoxie.t.domain.Users;

public class User_MsgSet_PageNum {
	private Users user=null;
	private List<Msg> msgSet=null;
	private int pageNum=0;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<Msg> getMsgSet() {
		return msgSet;
	}
	public void setMsgSet(List<Msg> msgSet) {
		this.msgSet = msgSet;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public User_MsgSet_PageNum() {
		super();
	}
	public User_MsgSet_PageNum(Users user, List<Msg> msgSet, int pageNum) {
		super();
		this.user = user;
		this.msgSet = msgSet;
		this.pageNum = pageNum;
	}
	
	
}
