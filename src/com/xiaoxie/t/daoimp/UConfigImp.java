package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xiaoxie.t.daoinface.IUConfig;
import com.xiaoxie.t.domain.UConfig;
import com.xiaoxie.t.tools.DBConnection;

public class UConfigImp implements IUConfig,Serializable{
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
	
	
	
	private UConfigImp(){
		
	}
	public static UConfigImp getUConfigImp(){
			return new UConfigImp();
	}



	public boolean addUC(UConfig uc) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into uconfig values(?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uc.getuId());
			pst.setString(2, uc.getuTName());
			pst.setString(3, uc.getuSex());
			pst.setString(4, uc.getuBir());
			pst.setString(5, uc.getuAddr());
			pst.setString(6, uc.getuQQ());
			pst.setString(7, uc.getuMsn());
			pst.setString(8, uc.getuSyn());
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



	public boolean delUC(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from uconfig where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
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



	public UConfig getUCByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select uid,utname,usex,ubir,uaddr,uqq,umsn,usyn from uconfig where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
			rst=pst.executeQuery();
			if(rst.next()){
				return new UConfig(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public boolean updateUC(UConfig uc) {
		try {
			conn=DBConnection.getConn();
			String sql="update uconfig set utname=?,usex=?,ubir=?,uaddr=?,uqq=?,umsn=?,usyn=? where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, uc.getuTName());
			pst.setString(2, uc.getuSex());
			pst.setString(3, uc.getuBir());
			pst.setString(4, uc.getuAddr());
			pst.setString(5, uc.getuQQ());
			pst.setString(6, uc.getuMsn());
			pst.setString(7, uc.getuSyn());
			pst.setInt(8, uc.getuId());
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
