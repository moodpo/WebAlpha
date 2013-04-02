package com.xiaoxie.t.domain;

public class Url {
	private int urlId=0;
	private String url=null;
	private String sUrl=null;
	private String mCon=null;
	private int mId=0;
	public int getUrlId() {
		return urlId;
	}
	public void setUrlId(int urlId) {
		this.urlId = urlId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getsUrl() {
		return sUrl;
	}
	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}
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
	public Url(String url, String sUrl, String mCon, int mId) {
		super();
		this.url = url;
		this.sUrl = sUrl;
		this.mCon = mCon;
		this.mId = mId;
	}
	
	
}
