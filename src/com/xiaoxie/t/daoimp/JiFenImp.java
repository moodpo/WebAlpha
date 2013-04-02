package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaoxie.t.daoinface.IJiFen;
import com.xiaoxie.t.domain.JiFen;
import com.xiaoxie.t.tools.DBConnection;

public class JiFenImp implements IJiFen,Serializable{
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
	
	
	
	private JiFenImp(){
		
	}
	public static JiFenImp getJiFenImp(){
			return new JiFenImp();
	}



	public boolean addJiFen(JiFen jf) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into jifen values(null,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, jf.getNum());
			pst.setInt(2, jf.getuId());
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



	public boolean delJiFen(int jId) {
		// TODO Auto-generated method stub
		return false;
	}



	public JiFen getJiFenByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select jid,num,uid from jifen where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return new JiFen(rst.getInt(1),rst.getInt(2),rst.getInt(3));
			}else{
				return new JiFen(0,0,uId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public boolean updateJiFen(JiFen jf) {
		try {
			conn=DBConnection.getConn();
			String sql="update jifen set num=? where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, jf.getNum());
			pst.setInt(2, jf.getuId());
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
}
