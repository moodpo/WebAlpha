package com.xiaoxie.t.domain;

import java.io.Serializable;

public class UConfig implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int uId=0;
	private String uTName=null;
	private String uSex=null;
	private String uBir=null;
	private String uAddr=null;
	private String uQQ=null;
	private String uMsn=null;
	private String uSyn=null;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuTName() {
		return uTName;
	}
	public void setuTName(String uTName) {
		this.uTName = uTName;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuBir() {
		return uBir;
	}
	public void setuBir(String uBir) {
		this.uBir = uBir;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	public String getuQQ() {
		return uQQ;
	}
	public void setuQQ(String uQQ) {
		this.uQQ = uQQ;
	}
	public String getuMsn() {
		return uMsn;
	}
	public void setuMsn(String uMsn) {
		this.uMsn = uMsn;
	}
	public String getuSyn() {
		return uSyn;
	}
	public void setuSyn(String uSyn) {
		this.uSyn = uSyn;
	}
	public UConfig(int uId, String uTName, String uSex, String uBir,
			String uAddr, String uQQ, String uMsn, String uSyn) {
		super();
		this.uId = uId;
		this.uTName = uTName;
		this.uSex = uSex;
		this.uBir = uBir;
		this.uAddr = uAddr;
		this.uQQ = uQQ;
		this.uMsn = uMsn;
		this.uSyn = uSyn;
	}
	
}
