package com.xiaoxie.t.domain;

import java.io.Serializable;

public class Msg implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mId=0;
	private String mCon=null;
	private String mDate=null;
	private int uId=0;
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getmCon() {
		return mCon;
	}
	public void setmCon(String mCon) {
		this.mCon = mCon;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	//消息携带的信息
	private int mfNum=0;
	private int mhNum=0;
	private Users user=null;
	public int getMfNum() {
		return mfNum;
	}
	public void setMfNum(int mfNum) {
		this.mfNum = mfNum;
	}
	public int getMhNum() {
		return mhNum;
	}
	public void setMhNum(int mhNum) {
		this.mhNum = mhNum;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Msg(int mId, String mCon, String mDate, int uId, int mfNum,
			int mhNum, Users user) {
		super();
		this.mId = mId;
		this.mCon = mCon;
		this.mDate = mDate;
		this.uId = uId;
		this.mfNum = mfNum;
		this.mhNum = mhNum;
		this.user = user;
	}
	public Msg() {
		super();
	}
	public Msg(int mId, String mCon, String mDate, int uId) {
		super();
		this.mId = mId;
		this.mCon = mCon;
		this.mDate = mDate;
		this.uId = uId;
	}
	public Msg(String mCon, int uId) {
		super();
		this.mCon = mCon;
		this.uId = uId;
	}
	
}
