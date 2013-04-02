package com.xiaoxie.t.domain;

public class Forword {
	private int forId=0;
	private String forcon=null;
	private String fordate=null;
	private int mId=0;
	private int uId=0;
	private int forUId=0;
	public int getForId() {
		return forId;
	}
	public void setForId(int forId) {
		this.forId = forId;
	}
	public String getForcon() {
		return forcon;
	}
	public void setForcon(String forcon) {
		this.forcon = forcon;
	}
	public String getFordate() {
		return fordate;
	}
	public void setFordate(String fordate) {
		this.fordate = fordate;
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
	public int getForUId() {
		return forUId;
	}
	public void setForUId(int forUId) {
		this.forUId = forUId;
	}
	public Forword() {
		super();
	}
	public Forword(String forcon, String fordate, int mId, int uId, int forUId) {
		super();
		this.forcon = forcon;
		this.fordate = fordate;
		this.mId = mId;
		this.uId = uId;
		this.forUId = forUId;
	}
	public Forword(int forId, String forcon, String fordate, int mId, int uId,
			int forUId) {
		super();
		this.forId = forId;
		this.forcon = forcon;
		this.fordate = fordate;
		this.mId = mId;
		this.uId = uId;
		this.forUId = forUId;
	}
	public Forword(String forcon, int mId, int uId, int forUId) {
		super();
		this.forcon = forcon;
		this.mId = mId;
		this.uId = uId;
		this.forUId = forUId;
	}
	
}
