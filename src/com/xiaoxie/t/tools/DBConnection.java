package com.xiaoxie.t.tools;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;

public class DBConnection {
	public static Connection getConn(){
    	try{
    		BasicDataSource dataSource=new BasicDataSource();
    		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    		dataSource.setUrl("jdbc:mysql://localhost:3306/web_alpha?useUnicode=true&characterEncoding=UTF-8");
    		dataSource.setUsername("root");
    		dataSource.setPassword("789173");
    		dataSource.setMaxActive(200);
    		dataSource.setMaxIdle(60);
    		dataSource.setMaxWait(5000);
    		return dataSource.getConnection();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
//	public static void main(String[] args) {
//		getConn();
//	}
}
