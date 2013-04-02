package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Hide;

public interface IHide {
	public boolean addHide(Hide hide);
	public boolean delHideByMId(int mId);
	public boolean isHided(int mId,int uId);
}
