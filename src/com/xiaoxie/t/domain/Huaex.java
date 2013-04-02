package com.xiaoxie.t.domain;

public class Huaex {
	private int id=0;
	private String hTitle=null;
	private String hCon=null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String gethTitle() {
		return hTitle;
	}
	public void sethTitle(String hTitle) {
		this.hTitle = hTitle;
	}
	public String gethCon() {
		return hCon;
	}
	public void sethCon(String hCon) {
		this.hCon = hCon;
	}
	public Huaex(String hTitle, String hCon) {
		super();
		this.hTitle = hTitle;
		this.hCon = hCon;
	}
	public Huaex(int id, String hTitle, String hCon) {
		super();
		this.id = id;
		this.hTitle = hTitle;
		this.hCon = hCon;
	}
	
}
