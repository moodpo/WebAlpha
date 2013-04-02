package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaoxie.t.daoinface.IForword;
import com.xiaoxie.t.domain.Forword;
import com.xiaoxie.t.tools.DBConnection;

public class ForwordImp implements IForword,Serializable{
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
	
	
	
	private ForwordImp(){
		
	}
	public static ForwordImp getForwordImp(){
			return new ForwordImp();
	}



	public boolean addFwd(Forword fwd) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into forword values(null,null,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, fwd.getForcon());
			pst.setInt(2, fwd.getmId());
			pst.setInt(3, fwd.getuId());
			pst.setInt(4, fwd.getForUId());
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



	public boolean delFwd(int forId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from forword where forId=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, forId);
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



	public int getMFNumByMId(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(forid) from forword where mid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
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



	public boolean update(Forword fwd) {
		// TODO Auto-generated method stub
		return false;
	}



	public int getFNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(forid) from forword where foruid=?";
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
}
