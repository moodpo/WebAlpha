package com.xiaoxie.t.daoinface;

import java.util.List;

import com.xiaoxie.t.domain.Msg;
import com.xiaoxie.t.result.MsgSet_PageNum;

public interface IMsg {
	//���
	public int addMsg(Msg msg);
	//ɾ��
	public boolean delMsg(int mId);
	//�޸�
	public boolean updateMsg(Msg msg);
	//��ѯ
	public List<Msg> getNewMsgSet(int num);
	public int getMNumByUId(int uId);
	public MsgSet_PageNum getMsgSetByUId(int uId,int nowPage,int pageSize);
	public int getAllMNumByUId(int uId);
	public MsgSet_PageNum getAllMsgSet(int nowPage,int pageSize);
	public int getAllMsgNum();
	public Msg getMsgByMId(int mId);
	public List<Msg> getMsgByMCon(String mCon,int nowPage,int pageSize);
	public int getMNumByMCon(String mCon);
}
