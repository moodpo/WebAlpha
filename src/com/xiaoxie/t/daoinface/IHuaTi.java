package com.xiaoxie.t.daoinface;

import java.util.List;

import com.xiaoxie.t.domain.HuaTi;

public interface IHuaTi {
	//���
	public boolean addHuaTi(HuaTi ht);
	//ɾ��
	public boolean delHuaTi(int mId);
	//�޸�
	public boolean updateHuaTi(HuaTi ht);
	//��ѯ
	public int getHuaNumByUId(int uId);
	public List<HuaTi> findHuaTiByHtitle(String huaTitle);
	public List<HuaTi> findTopHuaTi(int num);
	public List<HuaTi> findHuaTiByHtt(String hTitle);
	public List<HuaTi> findByAll();
}
