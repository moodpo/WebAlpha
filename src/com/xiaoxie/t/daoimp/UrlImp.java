package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaoxie.t.daoinface.IUrl;
import com.xiaoxie.t.domain.Url;
import com.xiaoxie.t.tools.DBConnection;

public class UrlImp implements IUrl,Serializable{
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
	
	
	
	private UrlImp(){
		
	}
	public static UrlImp getUrlImp(){
			return new UrlImp();
	}



	public boolean addUrl(Url url) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into url values(null,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, url.getUrl());
			pst.setString(2, url.getsUrl());
			pst.setInt(3, url.getmId());
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



	public boolean delUrlByMId(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from url where mid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
			int row=pst.executeUpdate();
			if(row>0){
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			close();
		}
		return false;
	}



	public String getUrlBySUrl(String surl) {
		// TODO Auto-generated method stub
		return null;
	}
}
