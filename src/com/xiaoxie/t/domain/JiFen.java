package com.xiaoxie.t.domain;

public class JiFen {
	private int jId=0;
	private int num=0;
	private int uId=0;
	public int getjId() {
		return jId;
	}
	public void setjId(int jId) {
		this.jId = jId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public JiFen(int jId, int num, int uId) {
		super();
		this.jId = jId;
		this.num = num;
		this.uId = uId;
	}
	
}
