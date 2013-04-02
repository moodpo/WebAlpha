package com.xiaoxie.t.daoinface;

import java.util.List;

import com.xiaoxie.t.domain.Users;

public interface IUsers {
	//���
	public boolean addUser(Users user);
	//ɾ��
	public boolean delUser(int uId);
	//�޸�
	public boolean updateUser(Users user);
	//��ѯ
	public Users getUserByMId(int mId);
	public List<Users> getNewUsers(int num);
	public Users isHaveUEmail(String uEmail);
	public List<Integer> getTopUId(int num);
	public Users getUserByUId(int uId);
	public List<Integer> getFoTopUId(int num);
	public List<Users> getUsersByUName(String uName);
}
