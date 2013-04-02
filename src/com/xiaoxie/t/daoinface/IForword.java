package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Forword;

public interface IForword {
	//添加
	public boolean addFwd(Forword fwd);
	//删除
	public boolean delFwd(int forId);
	//修改
	public boolean update(Forword fwd);
	//查询
	public int getMFNumByMId(int mId);//获得消息的转发数
	public int getFNumByUId(int uId);//获取用户的转发数
}
