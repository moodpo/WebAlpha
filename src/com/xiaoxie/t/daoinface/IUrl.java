package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Url;

public interface IUrl {
	//Ìí¼Ó
	public boolean addUrl(Url url);
	//É¾³ý
	public boolean delUrlByMId(int mId);
	//²éÑ¯
	public String getUrlBySUrl(String surl);
}
