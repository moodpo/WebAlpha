package com.xiaoxie.t.service;

import com.xiaoxie.t.domain.Url;
import com.xiaoxie.t.factory.Factory;

public class UrlService {
	public boolean addUrl(Url url){
		if(Factory.getUrlImp().addUrl(url)){
			return true;
		}
		return false;
	}
}
