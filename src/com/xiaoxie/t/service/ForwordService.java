package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.Forword;
import com.xiaoxie.t.factory.Factory;

public class ForwordService {
	public int getMfNumByMId(int mId){
		int num=Factory.getForwordImp().getMFNumByMId(mId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public int getFNumByUId(int uId){
		int num=Factory.getForwordImp().getFNumByUId(uId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public boolean addForword(Forword forword){
		return Factory.getForwordImp().addFwd(forword);
	}
}
