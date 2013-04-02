package com.xiaoxie.t.daoimp;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaoxie.t.daoinface.IMsg;
import com.xiaoxie.t.domain.Msg;
import com.xiaoxie.t.result.MsgSet_PageNum;
import com.xiaoxie.t.tools.DBConnection;

public class MsgImp implements IMsg,Serializable{

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
	
	
	
	private MsgImp(){
		
	}
	public static MsgImp getMessagesImp(){
			return new MsgImp();
	}
	public int addMsg(Msg msg) {
		try {
			conn=DBConnection.getConn();
			String sql="insert into msg values(null,?,null,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, msg.getmCon());
			pst.setInt(2, msg.getuId());
			int row=pst.executeUpdate();
			if(row>0){
				sql="select mid from msg order by mid desc limit 0,1";
				pst=conn.prepareStatement(sql);
				rst=pst.executeQuery();
				if(rst.next()){
				    return rst.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return 0;
	}

	public boolean delMsg(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="delete from msg where mid=?";
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

	public List<Msg> getNewMsgSet(int num) {
		try {
			conn=DBConnection.getConn();
			String sql="select mid,mcon,mdate,uid from msg order by mdate desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, num-1);
//			String sql="{call proc_getNewMsg(?)}";
//			cst=conn.prepareCall(sql);
//			cst.setInt(1, num);
			List<Msg> msgSet=new ArrayList<Msg>();
			rst=pst.executeQuery();
			while(rst.next()){
				Msg msg=new Msg(rst.getInt(1),rst.getString(2),rst.getString(3).substring(0,19),rst.getInt(4));
				msgSet.add(msg);
			}
			return msgSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}

	public boolean updateMsg(Msg msg) {
		return false;
	}



	public int getMNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(mid) from msg where uid=?";
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
/**
 * 所有消息的分页
 * 1.查询出所有的uid和follow里的uid
 * 
 */
	public MsgSet_PageNum getMsgSetByUId(int uId, int nowPage, int pageSize) {
		try {
			int allnum=getAllMNumByUId(uId);//总消息数
			conn=DBConnection.getConn();
			String sql="select mid,mcon,mdate,uid from msg where uid in(select fuid from follow where uid=?) or uid=? order by mdate desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
			pst.setInt(2, uId);
			pst.setInt(3, (nowPage-1)*pageSize);
			pst.setInt(4, nowPage*pageSize-1);
			
//			int allNum=getAllMNumByUId(uId);
//			conn=DBConnection.getConn();
//			String sql="{call proc_getMsg_FY(?,?,?,?,?)}";
//			cst=conn.prepareCall(sql);
//			cst.setInt(1, uId);
//			cst.setInt(2, pageSize);
//			cst.setInt(3, nowPage);
//			cst.setInt(4, allNum);
//			cst.registerOutParameter(5, java.sql.Types.INTEGER); //25/10 2.5
			rst=pst.executeQuery();
			List<Msg> msgSet=new ArrayList<Msg>();
			while(rst.next()){
				msgSet.add(new Msg(rst.getInt("mid"),rst.getString("mcon"),rst.getString("mdate").substring(0,19),rst.getInt("uid")));
			}
			return new MsgSet_PageNum(msgSet,(allnum%pageSize==0)?(allnum/pageSize):(allnum/pageSize+1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}


	public int getAllMNumByUId(int uId) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(mid) from msg where uid in (select fuid from follow where uid=?) or uid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, uId);
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



	public MsgSet_PageNum getAllMsgSet(int nowPage, int pageSize) {
		int allnum=this.getAllMsgNum();
		try {
			conn=DBConnection.getConn();
			String sql="select mid,mcon,mdate,uid from msg order by mdate desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, (nowPage-1)*pageSize);
			pst.setInt(2, nowPage*pageSize-1);
			rst=pst.executeQuery();
			List<Msg> msgSet=new ArrayList<Msg>();
			while(rst.next()){
				msgSet.add(new Msg(rst.getInt("mid"),rst.getString("mcon"),rst.getString("mdate").substring(0,19),rst.getInt("uid")));
			}
			return new MsgSet_PageNum(msgSet, (allnum%pageSize==0)?(allnum/pageSize):(allnum/pageSize+1));
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}
	public int getAllMsgNum(){
		try {
			conn=DBConnection.getConn();
			String sql="select count(*) from msg";
			pst=conn.prepareStatement(sql);
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



	public Msg getMsgByMId(int mId) {
		try {
			conn=DBConnection.getConn();
			String sql="select mid,mcon,mdate,uid from msg where mid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, mId);
			rst=pst.executeQuery();
			if(rst.next()){
				return new Msg(mId, rst.getString("mcon"),rst.getString("mdate").substring(0,19),rst.getInt("uid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public List<Msg> getMsgByMCon(String mCon,int nowPage,int pageSize) {
		try {
			conn=DBConnection.getConn();
			String sql="select mid,mcon,mdate,uid from msg where mcon like ? order by mdate desc limit ?,?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+mCon+"%");
			pst.setInt(2, (nowPage-1)*pageSize);
			pst.setInt(3, nowPage*pageSize-1);
			rst=pst.executeQuery();
			List<Msg> msgSet=new ArrayList<Msg>();
			while(rst.next()){
				msgSet.add(new Msg(rst.getInt("mid"), rst.getString("mcon"),rst.getString("mdate").substring(0,19),rst.getInt("uid")));
			}
			return msgSet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return null;
	}



	public int getMNumByMCon(String mCon) {
		try {
			conn=DBConnection.getConn();
			String sql="select count(mid) from msg where mcon like ?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "%"+mCon+"%");
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
