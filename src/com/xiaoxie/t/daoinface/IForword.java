package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Forword;

public interface IForword {
	//���
	public boolean addFwd(Forword fwd);
	//ɾ��
	public boolean delFwd(int forId);
	//�޸�
	public boolean update(Forword fwd);
	//��ѯ
	public int getMFNumByMId(int mId);//�����Ϣ��ת����
	public int getFNumByUId(int uId);//��ȡ�û���ת����
}
