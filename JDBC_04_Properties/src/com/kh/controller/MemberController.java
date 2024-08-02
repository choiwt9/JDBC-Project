package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.service.MemberService;
import com.kh.model.vo.Member;
import com.kh.view.MemberMenu;

//controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 역할
 //              요청받은 메소드에서 전달된 데이터를 가공처리한 후 dao로 전달하여 호출
//               dao로부터 반환받은 결과에 따라 성공인지 실패인지를 판단한 후 응답 

public class MemberController {

	/**
	 * 회원추가 요청 받을 메소드
	 * @param userId 회원아이디
	 */
	
	public void insertMember(String userId, String userPw, String name, String gender) {
		// view로부터 전달 받은 값들을 dao에게 전달하지 않고 
		//어딘가(member)에 담아서 전달
		//*기본생성자 생성후 setter 메소드 하나하나 저장
		//*매개변수 생성자를 사용하여 객체생성
		Member m = new Member(userId, userPw, name, gender);
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원추가 성공");
		}else {
			new MemberMenu().displayFailed("회원추가실패");
		}
	}
/**
 * 전체 회원 목록 조회 메소드
 * 
 */
	public void selectList() {
		ArrayList<Member> list = new MemberService().selectList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNodata("전체 조회 결과가 없음");
		}else {
			new MemberMenu().displayMemberList(list);
		}
	}
public void searchById(String userId) {
	
	Member m = new MemberDao().selectByUserId(userId);
	
	if(m==null) {
		new MemberMenu().displayNodata(userId + "에 해당하는 결과가 없음");
	}else {
		new MemberMenu().displayMember(m);
	}
}
public void deleteById(String userId) {
	int result = new MemberService().deleteByUserId(userId);
	
	if(result > 0) {
		new MemberMenu().displaySuccess("회원 탈퇴 성공");
	}else {
		new MemberMenu().displayFailed("회원 탈퇴 실패");
	}
}
	public void updateById(String userId
			                  , String userPw
			                  , String userName
			                  , String address
			                  , String phone
			                  , String hobby) {
//전달받은 값을 member 객체로 생성하여 dao에 전달
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPw(userPw);
		m.setUserName(userName);
		m.setAddress(address);
		m.setPhone(phone);
		m.setHobby(hobby);
		
		//DML(update) --> int (처리된 행 수)
		int result = new MemberDao().updateById(m);
		
		if(result > 0) {
			
			new MemberMenu().displaySuccess("회원정보 수정 성공");
		}else {
			new MemberMenu().displayFailed("회원정보 수정 실패");
	}
}
	/**
	 * 사용자가 입력한 이름을 키워드로 하여 화원정보 검색
	 * keyword 이름에 대한 키원드 값
	 */
	
	
	public void searchByName(String keyword) {
              ArrayList<Member> list = new MemberDao().selectByUserName(keyword);		
if(list.isEmpty()) {
	new MemberMenu().displayNodata("해당 이름에 대한 정보가 없습니다");
}else {
	new MemberMenu().displayMemberList(list);
}
	
	
	}
}









