package com.xiaoxie.t.domain;

public class Hide {
	private int hId=0;
	private String hCon=null;
	private String hDate=null;
	private int mId=0;
	private int uId=0;
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String gethCon() {
		return hCon;
	}
	public void sethCon(String hCon) {
		this.hCon = hCon;
	}
	public String gethDate() {
		return hDate;
	}
	public void sethDate(String hDate) {
		this.hDate = hDate;
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
	public Hide(String hCon, int mId, int uId) {
		super();
		this.hCon = hCon;
		this.mId = mId;
		this.uId = uId;
	}
	
}
