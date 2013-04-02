package com.xiaoxie.t.service;

import java.util.ArrayList;
import java.util.List;

import com.xiaoxie.t.domain.Msg;
import com.xiaoxie.t.domain.Users;
import com.xiaoxie.t.factory.Factory;
import com.xiaoxie.t.result.MsgSet_PageNum;

public class MsgService {
	/**
	 * Msg(int mId, String mCon, String mDate, int uId, int mfNum,
	 *     int mhNum, Users user)
	 * @param num
	 * @return
	 */
	public List<Msg> getNewMsg(int num){
		List<Msg> msgSet=Factory.getMsgImp().getNewMsgSet(num);
		if(msgSet!=null){
			List<Msg> tempMsgSet=new ArrayList<Msg>();
			for (int i = 0; i < msgSet.size(); i++) {
				Msg msg=msgSet.get(i);
				int mId=msg.getmId();
				int mfNum=new ForwordService().getMfNumByMId(mId);
				Users user=new UsersService().getUserByMId(mId);
				tempMsgSet.add(new Msg(mId,msg.getmCon(),msg.getmDate(),msg.getuId(),mfNum,0,user));
			}
			return tempMsgSet;
		}
		return null;
	}
	
	public int getMNumByUId(int uId){
		int num=Factory.getMsgImp().getMNumByUId(uId);
		if(num!=0){
			return num;
		}
		return 0;
	}
	public MsgSet_PageNum getMsgSetByUId(int uId,int nowPage,int pageSize){
		MsgSet_PageNum msp=Factory.getMsgImp().getMsgSetByUId(uId, nowPage, pageSize);
		if(msp!=null){
			List<Msg> msgSet=msp.getMsgSet();
			List<Msg> tempMsgSet=new ArrayList<Msg>();
			for (int i = 0; i < msgSet.size(); i++) {
				Msg msg=msgSet.get(i);
				int mId=msg.getmId();
				int mfNum=new ForwordService().getMfNumByMId(mId);
				Users user=new UsersService().getUserByMId(mId);
				boolean isHide=Factory.getHideImp().isHided(mId, uId);
				int ishide=0;
				if(isHide){//已收藏
					ishide=1;
				}
				tempMsgSet.add(new Msg(mId,msg.getmCon(),msg.getmDate(),msg.getuId(),mfNum,ishide,user));
			}
			msp.setMsgSet(tempMsgSet);
			return msp;
		}
		return null;
	}
	public int addMsg(Msg msg){
		int mId=Factory.getMsgImp().addMsg(msg);
		if(mId!=0){
			return mId;
		}
		return 0;
	}
	public boolean deleteMsgByMId(int mId){//删除话题中的，删除url中的
		Factory.getUrlImp().delUrlByMId(mId);
		Factory.getHuaTiImp().delHuaTi(mId);
		return Factory.getMsgImp().delMsg(mId);
	}
	public int getAllMsgNum(int uId){
		return Factory.getMsgImp().getAllMNumByUId(uId);
	}
	public MsgSet_PageNum getAllMsg(int nowPage,int pageSize){
		MsgSet_PageNum mspn=Factory.getMsgImp().getAllMsgSet(nowPage, pageSize);
		if(mspn!=null){
			List<Msg> msgSet=mspn.getMsgSet();
			List<Msg> tempMsgSet=new ArrayList<Msg>();
			for (int i = 0; i < msgSet.size(); i++) {
				Msg msg=msgSet.get(i);
				int mId=msg.getmId();
				int mfNum=new ForwordService().getMfNumByMId(mId);
				Users user=new UsersService().getUserByMId(mId);
				tempMsgSet.add(new Msg(mId,msg.getmCon(),msg.getmDate(),msg.getuId(),mfNum,0,user));
			}
			mspn.setMsgSet(tempMsgSet);
			return mspn;
		}
		return null;
	}
	public int getAllMsgNum(){
		return Factory.getMsgImp().getAllMsgNum();
	}
	public Msg getMsgByMId(int mId){
		Msg msg=Factory.getMsgImp().getMsgByMId(mId);
		int mfNum=new ForwordService().getMfNumByMId(mId);
		Users user=new UsersService().getUserByMId(mId);
		return new Msg(mId, msg.getmCon(), msg.getmDate(), msg.getuId(), mfNum, 0, user);
	}
	public List<Msg> getMsgByMCon(String mCon,int nowPage,int pageSize){
		List<Msg> msgSet=Factory.getMsgImp().getMsgByMCon(mCon,nowPage,pageSize);
		List<Msg> tempMsgSet=new ArrayList<Msg>();
		for (int i = 0; i < msgSet.size(); i++) {
			Msg msg=msgSet.get(i);
			int mId=msg.getmId();
			int mfNum=new ForwordService().getMfNumByMId(mId);
			Users user=new UsersService().getUserByMId(mId);
			tempMsgSet.add(new Msg(mId,msg.getmCon(),msg.getmDate(),msg.getuId(),mfNum,0,user));
		}
		return tempMsgSet;
	}
	public int getMNumByMCon(String mCon){
		return Factory.getMsgImp().getMNumByMCon(mCon);
	}
	
	
}
