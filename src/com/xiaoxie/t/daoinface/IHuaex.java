package com.xiaoxie.t.daoinface;

import java.util.List;

import com.xiaoxie.t.domain.Huaex;

public interface IHuaex {
	public List<Huaex> getHuaexByHTitle(String hTitle);
	public boolean addHua(Huaex he);
}
