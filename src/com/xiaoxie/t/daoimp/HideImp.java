package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaoxie.t.daoinface.IHide;
import com.xiaoxie.t.domain.Hide;
import com.xiaoxie.t.tools.DBConnection;

public class HideImp implements IHide,Serializable{
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
	
	
	
	private HideImp(){
		
	}
	public static HideImp getHideImp(){
			return new HideImp();
	}



	public boolean addHide(Hide hide) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into hide values(null,?,null,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, hide.gethCon());
			pst.setInt(2, hide.getmId());
			pst.setInt(3, hide.getuId());
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



	public boolean delHideByMId(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from hide where mid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
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



	public boolean isHided(int mId, int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select * from hide where mid=? and uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
			pst.setInt(2, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return false;
	}
}
