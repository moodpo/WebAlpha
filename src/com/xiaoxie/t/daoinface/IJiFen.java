package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.JiFen;

public interface IJiFen {
	//���
	public boolean addJiFen(JiFen jf);
	//ɾ��
	public boolean delJiFen(int jId);
	//�޸�
	public boolean updateJiFen(JiFen jf);
	//��ѯ
	public JiFen getJiFenByUId(int uId);
}
