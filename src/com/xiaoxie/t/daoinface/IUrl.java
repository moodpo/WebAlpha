package com.xiaoxie.t.daoinface;

import com.xiaoxie.t.domain.Url;

public interface IUrl {
	//���
	public boolean addUrl(Url url);
	//ɾ��
	public boolean delUrlByMId(int mId);
	//��ѯ
	public String getUrlBySUrl(String surl);
}
