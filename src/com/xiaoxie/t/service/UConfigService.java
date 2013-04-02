package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.UConfig;
import com.xiaoxie.t.factory.Factory;

public class UConfigService {
	public UConfig getUCByUId(int uId){
		UConfig uc=Factory.getUConfigImp().getUCByUId(uId);
		if(uc!=null){
			return uc;
		}
		return null;
	}
	public boolean addUC(UConfig uc){
		if(Factory.getUConfigImp().addUC(uc)){
			return true;
		}
		return false;
	}
	public boolean updateUC(UConfig uc){
		if(Factory.getUConfigImp().updateUC(uc)){
			return true;
		}
		return false;
	}
	public boolean updateAndAddUC(UConfig uc){
		int uId=uc.getuId();
		if(Factory.getUConfigImp().getUCByUId(uId)!=null){//已经存在了
			return updateUC(uc);
		}
		else{
			return addUC(uc);
		}
	}
}
