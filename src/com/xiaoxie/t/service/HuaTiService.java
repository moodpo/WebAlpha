package com.xiaoxie.t.service;

import java.util.List;

import com.xiaoxie.t.domain.HuaTi;
import com.xiaoxie.t.factory.Factory;

public class HuaTiService {
	public int getHuaNumByUId(int uId){
		int num=Factory.getHuaTiImp().getHuaNumByUId(uId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public boolean addHuaTi(HuaTi ht){
		if(Factory.getHuaTiImp().addHuaTi(ht)){
			return true;
		}
		return false;
	}
	public List<HuaTi> findHuaTiByHuaTitle(String huaTitle){
		return Factory.getHuaTiImp().findHuaTiByHtitle(huaTitle);
	}
	public List<HuaTi> findTopHuaTi(int num){
		return Factory.getHuaTiImp().findTopHuaTi(num);
	}
	public List<HuaTi> findHuaTiByHtt(String hTitle){
		return Factory.getHuaTiImp().findHuaTiByHtt(hTitle);
	}
}
