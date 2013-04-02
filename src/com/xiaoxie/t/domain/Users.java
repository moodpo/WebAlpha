package com.xiaoxie.t.domain;

import java.io.Serializable;

public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uId=0;
	private String uEmail=null;
	private String uName=null;
	private String uPW=null;
	private String uImg=null;
	private String ustate=null;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPW() {
		return uPW;
	}
	public void setuPW(String uPW) {
		this.uPW = uPW;
	}
	public String getuImg() {
		return uImg;
	}
	public void setuImg(String uImg) {
		this.uImg = uImg;
	}
	public String getUstate() {
		return ustate;
	}
	public void setUstate(String ustate) {
		this.ustate = ustate;
	}
	//用户携带的信息
	private JiFen jNum=null;// 积分
	private int huaNum=0;//话题数
	private int mNum=0;//微博数
	private int forNum=0;//转发数
	private int fowNum=0;//关注数
	private int fowedNum=0;//粉丝数
	private UConfig uc=null;
	public JiFen getjNum() {
		return jNum;
	}
	public void setjNum(JiFen jNum) {
		this.jNum = jNum;
	}
	public int getHuaNum() {
		return huaNum;
	}
	public void setHuaNum(int huaNum) {
		this.huaNum = huaNum;
	}
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public int getForNum() {
		return forNum;
	}
	public void setForNum(int forNum) {
		this.forNum = forNum;
	}
	public int getFowNum() {
		return fowNum;
	}
	public void setFowNum(int fowNum) {
		this.fowNum = fowNum;
	}
	public int getFowedNum() {
		return fowedNum;
	}
	public void setFowedNum(int fowedNum) {
		this.fowedNum = fowedNum;
	}
	public UConfig getUc() {
		return uc;
	}
	public void setUc(UConfig uc) {
		this.uc = uc;
	}
	public Users(int uId, String uEmail, String uName, String uPW, String uImg,
			String ustate) {
		super();
		this.uId = uId;
		this.uEmail = uEmail;
		this.uName = uName;
		this.uPW = uPW;
		this.uImg = uImg;
		this.ustate = ustate;
	}
	public Users(int uId, String uEmail, String uName, String uPW, String uImg,
			String ustate, UConfig uc) {
		super();
		this.uId = uId;
		this.uEmail = uEmail;
		this.uName = uName;
		this.uPW = uPW;
		this.uImg = uImg;
		this.ustate = ustate;
		this.uc = uc;
	}
	public Users(String uEmail, String uName, String uPW, String uImg,
			String ustate) {
		super();
		this.uEmail = uEmail;
		this.uName = uName;
		this.uPW = uPW;
		this.uImg = uImg;
		this.ustate = ustate;
	}
	public Users(int uId, String uEmail, String uName, String uPW, String uImg,
			String ustate, JiFen jNum, int huaNum, int mNum, int forNum,
			int fowNum, int fowedNum, UConfig uc) {
		super();
		this.uId = uId;
		this.uEmail = uEmail;
		this.uName = uName;
		this.uPW = uPW;
		this.uImg = uImg;
		this.ustate = ustate;
		this.jNum = jNum;
		this.huaNum = huaNum;
		this.mNum = mNum;
		this.forNum = forNum;
		this.fowNum = fowNum;
		this.fowedNum = fowedNum;
		this.uc = uc;
	}
	public Users() {
		super();
	}
	public Users(String uEmail, String uPW) {
		super();
		this.uEmail = uEmail;
		this.uPW = uPW;
	}
	public Users(int uId, String uName, String uImg) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uImg = uImg;
	}
	
	
}
