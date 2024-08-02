package com.kh.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	// 매번 반복적으로 사용한 코드들을 메소드로 정의하기 위한 용도(공통 템플릿)
	// 객체를 매번 생성하지 않고 메소드를 호출 할 수 있도록,
	// 모든 메소드를 static 메소드로 정의
	// => 싱글톤 패턴 : 메모리영역에 한번만 올려두고 매번 재사용하는 패턴
	
	//1. Connection 객체 생성 메소드
	/**
	 * Connection 객체 생성 메소드
	 * db접속 후 해당 커넥션 객체를 반환
	 * return 생성된 Connection 객체
	 */
	public static Connection getConnection() {
		
		Properties prop = new Properties();
		Connection conn = null;
		try {
			//설정파일 읽어서 Properties 객체에 담기 = > load 메소드
			prop.load(new FileInputStream("resources/driver.properties"));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("username"), 
					prop.getProperty("password"));
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					                      ,"C##JDBC"
				                         ,"JDBC");
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	/**
	 * commit 처리를 해주는 메소드
	 * @param conn 생성된 Connection 객체
	 */
public static void commit(Connection conn) {
	try {
		//Connection 객체가 생성되어 있고 (null이 아니고), 닫혀있지 않을 때
		if(conn !=null && !conn.isClosed())
			conn.commit();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void rollback(Connection conn) {
	try {
		//Connection 객체가 생성되어 있고 (null이 아니고), 닫혀있지 않을 때
		if(conn !=null && !conn.isClosed())
			conn.rollback();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	/**
	 * Connection 객체를 close 처리해주는 메소드
	 * 
	 */
public static void close(Connection conn) {
	try {
		//Connection 객체가 생성되어 있고 (null이 아니고), 닫혀있지 않을 때
		if(conn !=null && !conn.isClosed())
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	
	}
}

public static void close(Statement stmt) {
	try {
		//Connection 객체가 생성되어 있고 (null이 아니고), 닫혀있지 않을 때
		if (stmt != null && !stmt.isClosed())
			stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();

	}
  }

/**
 * ResultSet 객체를 close 처리 해주는 메소드
 * @param rset
 */
public static void close(ResultSet rset) {
	try {
		//Connection 객체가 생성되어 있고 (null이 아니고), 닫혀있지 않을 때
		if (rset != null && !rset.isClosed())
			rset.close();
	} catch (SQLException e) {
		e.printStackTrace();
}

}
}

