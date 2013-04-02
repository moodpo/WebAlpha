package com.xiaoxie.t.daoimp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaoxie.t.daoinface.IHuaex;
import com.xiaoxie.t.domain.Huaex;
import com.xiaoxie.t.tools.DBConnection;

public class HuaexImp implements IHuaex{
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
	
	
	
	private HuaexImp(){
		
	}
	public static HuaexImp getInstance(){
		return new HuaexImp();
	}



	public List<Huaex> getHuaexByHTitle(String hTitle) {
		try {
			conn=DBConnection.getConn();
			String sql="select id,htitle,hcon from huaex where htitle like ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+hTitle+"%");
			List<Huaex> heSet=new ArrayList<Huaex>();
			rst=pst.executeQuery();
			while(rst.next()){
				heSet.add(new Huaex(rst.getInt("id"), rst.getString("htitle"), rst.getString("hcon")));
			}
			return heSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public boolean addHua(Huaex he) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into huaex values(null,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, he.gethTitle());
			pst.setString(2, he.gethCon());
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
