package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.Hide;
import com.xiaoxie.t.factory.Factory;

public class HideService {
	public boolean addHide(Hide hide){
		return Factory.getHideImp().addHide(hide);
	}
	public boolean delHideByMId(int mId){
		return Factory.getHideImp().delHideByMId(mId);
	}
}
