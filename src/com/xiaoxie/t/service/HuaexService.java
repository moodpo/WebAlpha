package com.xiaoxie.t.service;

import java.util.List;

import com.xiaoxie.t.domain.Huaex;
import com.xiaoxie.t.factory.Factory;

public class HuaexService {
	public List<Huaex> getHuaexByHTitle(String hTitle){
		return Factory.getHuaexImp().getHuaexByHTitle(hTitle);
	}
	public boolean addHuaex(Huaex he){
		return Factory.getHuaexImp().addHua(he);
	}
}
