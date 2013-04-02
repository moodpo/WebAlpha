package com.xiaoxie.t.domain;

public class Follow {
	private int fId=0;
	private int fuId=0;
	private int uId=0;
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public int getFuId() {
		return fuId;
	}
	public void setFuId(int fuId) {
		this.fuId = fuId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public Follow(int fuId, int uId) {
		super();
		this.fuId = fuId;
		this.uId = uId;
	}
	public Follow(int fId, int fuId, int uId) {
		super();
		this.fId = fId;
		this.fuId = fuId;
		this.uId = uId;
	}
	public Follow() {
		super();
	}
	
}
