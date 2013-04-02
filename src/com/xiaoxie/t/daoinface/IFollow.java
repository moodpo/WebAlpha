package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Follow;

public interface IFollow {
	//���
	public boolean addFollow(Follow fow);
	//ɾ��
	public boolean delFollow(int fId);
	//�޸�
	public boolean updateFow(Follow fow);
	//��ѯ
	public int getFowNumByUId(int uId);//��ע��
	public int getFowedNumByUId(int uId);//��˿��
	public int getFIdByUIdFUId(int fuId,int uId);
	public boolean unFollow(int fuId,int uId);
}
