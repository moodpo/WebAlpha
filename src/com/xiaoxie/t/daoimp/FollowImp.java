package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.xiaoxie.t.daoinface.IFollow;
import com.xiaoxie.t.domain.Follow;
import com.xiaoxie.t.tools.DBConnection;

public class FollowImp implements IFollow,Serializable{
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
	
	
	
	private FollowImp(){
		
	}
	public static FollowImp getFollowImp(){
			return new FollowImp();
	}



	public boolean addFollow(Follow fow) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into follow values(null,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, fow.getFuId());
			pst.setInt(2, fow.getuId());
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



	public boolean delFollow(int fId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from follow where fid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, fId);
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



	public int getFowNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(fid) from follow where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return rst.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return 0;
	}



	public int getFowedNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(fid) from follow where fuid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return rst.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return 0;
	}



	public boolean updateFow(Follow fow) {
		// TODO Auto-generated method stub
		return false;
	}



	public int getFIdByUIdFUId(int fuId, int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select fid from follow where fuid=? and uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, fuId);
			pst.setInt(2, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return rst.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return 0;
	}



	public boolean unFollow(int fuId, int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from follow where fuid=? and uid =?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, fuId);
			pst.setInt(2, uId);
			int row=pst.executeUpdate();
			if(row>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
