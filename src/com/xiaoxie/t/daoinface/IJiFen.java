package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.JiFen;

public interface IJiFen {
	//Ìí¼Ó
	public boolean addJiFen(JiFen jf);
	//É¾³ý
	public boolean delJiFen(int jId);
	//ÐÞ¸Ä
	public boolean updateJiFen(JiFen jf);
	//²éÑ¯
	public JiFen getJiFenByUId(int uId);
}
