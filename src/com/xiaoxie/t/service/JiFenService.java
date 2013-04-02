package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.JiFen;
import com.xiaoxie.t.factory.Factory;

public class JiFenService {
	public JiFen getJiFenByUId(int uId){
		JiFen jf=Factory.getJiFenImp().getJiFenByUId(uId);
		if(jf!=null){
			return jf;
		}
		return null;
	}
}
