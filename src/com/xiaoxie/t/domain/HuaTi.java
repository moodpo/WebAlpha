package com.xiaoxie.t.domain;

public class HuaTi {
	private int huaId=0;
	private String huaTitle=null;
	private int mId=0;
	private int uId=0;
	public int getHuaId() {
		return huaId;
	}
	public void setHuaId(int huaId) {
		this.huaId = huaId;
	}
	public String getHuaTitle() {
		return huaTitle;
	}
	public void setHuaTitle(String huaTitle) {
		this.huaTitle = huaTitle;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public HuaTi(String huaTitle, int mId, int uId) {
		super();
		this.huaTitle = huaTitle;
		this.mId = mId;
		this.uId = uId;
	}
	public HuaTi(int huaId, String huaTitle, int mId, int uId) {
		super();
		this.huaId = huaId;
		this.huaTitle = huaTitle;
		this.mId = mId;
		this.uId = uId;
	}
	
}
