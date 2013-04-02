package com.xiaoxie.t.service;

import java.util.ArrayList;
import java.util.List;
import com.xiaoxie.t.domain.JiFen;
import com.xiaoxie.t.domain.UConfig;
import com.xiaoxie.t.domain.Users;
import com.xiaoxie.t.factory.Factory;

public class UsersService {
	public Users getUserByMId(int mId){
		Users user=Factory.getUsersImp().getUserByMId(mId);
		if(user!=null){
			return new Users(user.getuId(),user.getuEmail(),user.getuName(),user.getuPW(),user.getuImg()
					,user.getUstate(),new UConfigService().getUCByUId(user.getuId()));
		}
		return null;
	}
	
	public boolean addUser(Users user){
		if(Factory.getUsersImp().addUser(user)){
			return true;
		}
		return false;
	}
	/**
	 * int uId, String uEmail, String uName, String uPW, String uImg,
			String ustate, JiFen jNum, int huaNum, int mNum, int forNum,
			int fowNum, int fowedNum, UConfig uc
	 * @param user
	 * @return
	 */
	public Users checkLogin(Users user){
		Users us=Factory.getUsersImp().isHaveUEmail(user.getuEmail());
		if(us!=null){
			if(us.getuPW().equals(user.getuPW().trim())){
				String uState="login";
				us.setUstate(uState);
				if(Factory.getUsersImp().updateUser(us)){
					int uId=us.getuId();
					JiFen jNum=new JiFenService().getJiFenByUId(uId);
					int huaNum=new HuaTiService().getHuaNumByUId(uId);
					int mNum=new MsgService().getMNumByUId(uId);
					int forNum=new ForwordService().getFNumByUId(uId);
					int fowNum=new FollowService().getFowNumByUId(uId);
					int fowedNum=new FollowService().getFowedNumByUId(uId);
					UConfig uc=new UConfigService().getUCByUId(uId);
					return new Users(uId,us.getuEmail(),us.getuName(),us.getuPW(),us.getuImg(),us.getUstate(),jNum,
							huaNum,mNum,forNum,fowNum,fowedNum,uc);
				}
			}
		}
		return null;
	}
	public List<Users> getTopUsers(int num){
		List<Users> userSet=new ArrayList<Users>();
		List<Integer> uIdSet=Factory.getUsersImp().getTopUId(num);
		for (Integer integer : uIdSet) {
			userSet.add(this.getUserByUId(integer));
		}
		if(userSet!=null){
			return userSet;
		}
		return null;
	}
	public boolean updateUsers(Users user){
		if(Factory.getUsersImp().updateUser(user)){
			return true;
		}
		return false;
	}
	public Users getUserByUId(int uId){
		return Factory.getUsersImp().getUserByUId(uId);
	}
	public List<Users> getFoTopUsers(int num){
		List<Users> userSet=new ArrayList<Users>();
		List<Integer> uIdSet=Factory.getUsersImp().getFoTopUId(num);
		for (Integer integer : uIdSet) {
			userSet.add(this.getUserByUId(integer));
		}
		if(userSet!=null){
			return userSet;
		}
		return null;
	}
	public List<Users> getUsersByUName(String uName){
		List<Users> us=new ArrayList<Users>();
		List<Users> userSet=Factory.getUsersImp().getUsersByUName(uName);
		if(userSet!=null)
		for (Users users : userSet) {
			int uId=users.getuId();
			JiFen jNum=new JiFenService().getJiFenByUId(uId);
			int huaNum=new HuaTiService().getHuaNumByUId(uId);
			int mNum=new MsgService().getMNumByUId(uId);
			int forNum=new ForwordService().getFNumByUId(uId);
			int fowNum=new FollowService().getFowNumByUId(uId);
			int fowedNum=new FollowService().getFowedNumByUId(uId);
			UConfig uc=new UConfigService().getUCByUId(uId);
			us.add(new Users(uId,users.getuEmail(),users.getuName(),users.getuPW(),users.getuImg(),users.getUstate(),jNum,
							huaNum,mNum,forNum,fowNum,fowedNum,uc));
		}
		return us;
	}
}
