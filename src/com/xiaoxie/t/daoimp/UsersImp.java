package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaoxie.t.daoinface.IUsers;
import com.xiaoxie.t.domain.Users;
import com.xiaoxie.t.tools.DBConnection;

public class UsersImp implements IUsers,Serializable{
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private PreparedStatement pst=null;
	private ResultSet rst=null;
	private CallableStatement cst=null;
	public void close(){
		if(rst!=null){
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(cst!=null){
			try {
				cst.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(pst!=null){
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private UsersImp(){
		
	}
	public static UsersImp getUsersImp(){
			return new UsersImp();
	}



	public boolean addUser(Users user) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into users values(null,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getuEmail());
			pst.setString(2, user.getuName());
			pst.setString(3, user.getuPW());
			pst.setString(4, user.getuImg());
			pst.setString(5, user.getUstate());
			int row=pst.executeUpdate();
			if(row>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return false;
	}



	public boolean delUser(int uId) {
		// TODO Auto-generated method stub
		return false;
	}



	public Users getUserByMId(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="select uid,uemail,uname,upw,uimg,ustate from users where uid=(select uid from msg where mid=?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
			rst=pst.executeQuery();
			if(rst.next()){
				return new Users(rst.getInt("uid"),rst.getString("uemail"),rst.getString("uname"),
						rst.getString("upw"),rst.getString("uimg"),rst.getString("ustate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public boolean updateUser(Users user) {
		try {
			conn=DBConnection.getConn();
			String sql="update users set uemail=?,uname=?,upw=?,uimg=?,ustate=? where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, user.getuEmail());
			pst.setString(2, user.getuName());
			pst.setString(3, user.getuPW());
			pst.setString(4, user.getuImg());
			pst.setString(5, user.getUstate());
			pst.setInt(6, user.getuId());
			int row=pst.executeUpdate();
			if(row>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return false;
	}



	public List<Users> getNewUsers(int num) {
		try {
			conn=DBConnection.getConn();
			String sql="select uid,uemail,uname,upw,uimg,ustate from users order by uid desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, num-1);
			List<Users> uIdSet=new ArrayList<Users>();
			rst=pst.executeQuery();
			while(rst.next()){
				uIdSet.add(new Users(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
			}
			return uIdSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public Users isHaveUEmail(String uEmail) {
		try {
			conn=DBConnection.getConn();
			String sql="select uid,uemail,uname,upw,uimg,ustate from users where uemail=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, uEmail);
			rst=pst.executeQuery();
			if(rst.next()){
				return new Users(rst.getInt("uid"),rst.getString("uemail"),rst.getString("uname"),
						rst.getString("upw"),rst.getString("uimg"),rst.getString("ustate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}


/**
 * select top 10 uid,count(mid) as gs from messages group by uid order by gs desc
 */
	public List<Integer> getTopUId(int num){
		try {
			conn=DBConnection.getConn();
			String sql="select uid,count(mid) as gs from msg group by uid order by gs desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, num-1);
			List<Integer> uIdSet=new ArrayList<Integer>();
			rst=pst.executeQuery();
			while(rst.next()){
				uIdSet.add(rst.getInt(1));
			}
			return uIdSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



public Users getUserByUId(int uId) {
	try {
		conn=DBConnection.getConn();
		String sql="select uid,uemail,uname,upw,uimg,ustate from users where uid=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, uId);
		rst=pst.executeQuery();
		if(rst.next()){
			return new Users(rst.getInt("uid"),rst.getString("uemail"),rst.getString("uname"),
					rst.getString("upw"),rst.getString("uimg"),rst.getString("ustate"));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		close();
	}
	return null;
}



public List<Integer> getFoTopUId(int num) {
	try {
		conn=DBConnection.getConn();
		String sql="select fuid,count(fid) as gs from follow group by fuid order by gs desc limit ?,?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, 0);
		pst.setInt(2, num-1);
		List<Integer> uIdSet=new ArrayList<Integer>();
		rst=pst.executeQuery();
		while(rst.next()){
			uIdSet.add(rst.getInt(1));
		}
		return uIdSet;
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		close();
	}
	return null;
   }



public List<Users> getUsersByUName(String uName) {
	try {
		conn=DBConnection.getConn();
		String sql="select uid,uemail,uname,upw,uimg,ustate from users where uname like ?";
		pst=conn.prepareStatement(sql);
		pst.setString(1, "%"+uName+"%");
		List<Users> userSet=new ArrayList<Users>();
		rst=pst.executeQuery();
		while(rst.next()){
			userSet.add(new Users(rst.getInt("uid"),rst.getString("uemail"),rst.getString("uname"),
						rst.getString("upw"),rst.getString("uimg"),rst.getString("ustate")));
		}
		return userSet;
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		close();
	}
	return null;
}
}
