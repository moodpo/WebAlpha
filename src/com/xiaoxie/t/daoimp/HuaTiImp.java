package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaoxie.t.daoinface.IHuaTi;
import com.xiaoxie.t.domain.HuaTi;
import com.xiaoxie.t.tools.DBConnection;

public class HuaTiImp implements IHuaTi,Serializable{
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
	
	
	
	private HuaTiImp(){
		
	}
	public static HuaTiImp getHuaTiImp(){
			return new HuaTiImp();
	}



	public boolean addHuaTi(HuaTi ht) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into huati values(null,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, ht.getHuaTitle());
			pst.setInt(2, ht.getmId());
			pst.setInt(3, ht.getuId());
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



	public boolean delHuaTi(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from huati where mid=?";
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



	public int getHuaNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(huaid) from huati where uid=?";
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



	public boolean updateHuaTi(HuaTi ht) {
		// TODO Auto-generated method stub
		return false;
	}



	public List<HuaTi> findHuaTiByHtitle(String hTitle) {
		try {
			conn=DBConnection.getConn();
			String sql="select huaid,huatitle,mid,uid from huati where huatitle like ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+hTitle+"%");
			rst=pst.executeQuery();
			List<HuaTi> htSet=new ArrayList<HuaTi>();
			while(rst.next()){
				htSet.add(new HuaTi(rst.getInt("huaid"),rst.getString("huatitle"), rst.getInt("mid"), rst.getInt("uid")));
			}
			return htSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public List<HuaTi> findTopHuaTi(int num) {
		try {
			conn=DBConnection.getConn();
			String sql="select huaid,huatitle,mid,uid,count(huaid) as num from huati group by huatitle order by num desc limit 0,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, num);
			rst=pst.executeQuery();
			List<HuaTi> htSet=new ArrayList<HuaTi>();
			while(rst.next()){
				htSet.add(new HuaTi(rst.getInt("huaid"), rst.getString("huatitle"), rst.getInt("mid"), rst.getInt("uid")));
			}
			return htSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public List<HuaTi> findHuaTiByHtt(String hTitle) {
		//try {
			List<HuaTi> htSetTemp=this.findByAll();
			List<HuaTi> htSet=new ArrayList<HuaTi>();
			for (HuaTi huaTi : htSetTemp) {
				String huaTitle=huaTi.getHuaTitle();
				if(hTitle.indexOf(huaTitle)!=-1){//包含
					htSet.add(huaTi);
				}
			}
			return htSet;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally{
//			//close();
//		}
//		return null;
	}



	public List<HuaTi> findByAll() {
		try {
			conn=DBConnection.getConn();
			String sql="select huaid,huatitle,mid,uid from huati";
			pst=conn.prepareStatement(sql);
			rst=pst.executeQuery();
			List<HuaTi> htSet=new ArrayList<HuaTi>();
			while(rst.next()){
				htSet.add(new HuaTi(rst.getInt("huaid"),rst.getString("huatitle"), rst.getInt("mid"), rst.getInt("uid")));
			}
			return htSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}
}
