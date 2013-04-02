package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.UConfig;

public interface IUConfig {
	//Ìí¼Ó
	public boolean addUC(UConfig uc);
	//É¾³ý
	public boolean delUC(int uId);
	//ÐÞ¸Ä
	public boolean updateUC(UConfig uc);
	//²éÑ¯
	public UConfig getUCByUId(int uId);
}
