package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.UConfig;

public interface IUConfig {
	//���
	public boolean addUC(UConfig uc);
	//ɾ��
	public boolean delUC(int uId);
	//�޸�
	public boolean updateUC(UConfig uc);
	//��ѯ
	public UConfig getUCByUId(int uId);
}
