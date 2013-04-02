package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.Follow;
import com.xiaoxie.t.factory.Factory;

public class FollowService {
	public int getFowNumByUId(int uId){
		int num=Factory.getFollowImp().getFowNumByUId(uId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public int getFowedNumByUId(int uId){
		int num=Factory.getFollowImp().getFowedNumByUId(uId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public boolean addFollow(Follow fow){
		return Factory.getFollowImp().addFollow(fow);
	}
	public int getFIdByUIdFUId(int fuId,int uId){
		return Factory.getFollowImp().getFIdByUIdFUId(fuId, uId);
	}
	public boolean unFollow(int fuId,int uId){
		return Factory.getFollowImp().unFollow(fuId, uId);
	}
}
