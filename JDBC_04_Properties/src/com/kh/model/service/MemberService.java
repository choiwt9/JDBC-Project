package com.kh.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;

public class MemberService {

	
	
	/*
	 * [1] Connection 객체 생성
	 *    -jdbc driver 등록
	 *    -Connection 객체 생성
	 * [2] dml문 실행 시 트랜잭션 처리
	 *    -commit
	 *    -rollback
	 * [3] Connection 객체 반납
	 *    -close     
	 */
public int insertMember(Member m) {
	//1) Connection 객체 생성
	  Connection conn = JDBCTemplate.getConnection();
	  //2)dao에게 전달받은 데이터(Member m)와 Connection 객체를 전달하여
	  // db 처리결과를 받기
	  int result = new MemberDao().insertMember(conn, m);
	  //3)
	  if(result > 0) {
		  JDBCTemplate.commit(conn);
	  } else {
		  JDBCTemplate.rollback(conn);
	  }
	  
	  //4)
	  JDBCTemplate.close(conn);
	return result;
}

public ArrayList<Member> selectList() {
	
	Connection conn = JDBCTemplate.getConnection();
	ArrayList<Member> List = new MemberDao().selectList(conn);
	JDBCTemplate.close(conn);
	
	return List;
}

public void updateById(Member m) {
         Connection conn = JDBCTemplate.getConnection();
         
         int result = new MemberDao().updateById(conn, m);
         
         if(result > 0) {
        	 JDBCTemplate.commit(conn);
        	 
         }else {
        	 JDBCTemplate.rollback(conn);
         }
}

public void updateById(Connection conn, Member m) {

PreparedStatement pstmt = null;

String sql = "UPDATE MEMBER" 
            + "SET USERPW = ?'"   + "USERNAME = ?'" + 
		   "ADDRESS = ? '"  
		+ "PHONE = ?'" + "HOBBY =?'"
		+ "WHERE USERID = ?" ;


int result;
try { 
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, m.getUserPw());
pstmt.setString(2, m.getUserName());
pstmt.setString(3, m.getAddress());
pstmt.setString(4, m.getPhone());
pstmt.setString(5, m.getHobby());
pstmt.setString(6, m.getUserId());

result = pstmt.executeUpdate();

}catch(SQLException e) {
e.printStackTrace();
}finally {
	JDBCTemplate.close(pstmt);
}
return;

}

public int deleteByUserId(String userId) {
	
	Connection conn = JDBCTemplate.getConnection();
	
	int result = new MemberDao().deleteByUserId(conn, userId);
	
	if(result > 0) {
		JDBCTemplate.commit(conn);
	}else {
		JDBCTemplate.rollback(conn);
	}
	JDBCTemplate.close(conn);
}
	return result;
}
	
}





