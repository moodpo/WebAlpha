package com.xiaoxie.t.result;

import java.util.List;

import com.xiaoxie.t.domain.Msg;

public class MsgSet_PageNum {
	private List<Msg> msgSet=null;
	private int pageNum=0;
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
	public MsgSet_PageNum(List<Msg> msgSet, int pageNum) {
		super();
		this.msgSet = msgSet;
		this.pageNum = pageNum;
	}
	public MsgSet_PageNum() {
		super();
	}
	
}
