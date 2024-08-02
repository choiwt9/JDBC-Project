package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

//View : 사용자가 보게 될 시각적인 요소(화면) 출력 및 입력
public class MemberMenu {
	//Scanner 객체 생성
	private Scanner sc = new Scanner(System.in);

	//MemberController 객체 생성
	private MemberController mc = new MemberController();

/*
 * 사용자가 보게 될 첫 화면 : 메인메뉴(화면)
 */
public void mainMenu() {
	while(true) {
	
        System.out.println("==========회원관리프로그램==========");
        System.out.println("1. 회원 추가");     //C (Create)
        System.out.println("2. 전체 회원 조회"); //R (read)
        System.out.println("3. 회원 아이디로 검색");//R(read)
        System.out.println("4. 회원 정보 수정"); //U (update)
        System.out.println("5. 회원 탈퇴");     //D (delete)
        System.out.println("6 : 키워드로 회원 검색");
        System.out.println("9. 프로그램 종료");

        System.out.println(">> 메뉴번호: ");
        int menu = sc.nextInt();
        sc.nextLine();
        
        switch (menu) {
		case 1:
			addMenu();
			break;
		case 2:
			mc.selectList();
			break;
		case 3:
			searchById();
			break;
		case 4:
			updateMenu();
			break;
		case 5:
			deleteMember();
			break;
		case 6:
			searchByName();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다...");
			break;
		default:
			break;
		}
        
	}
}

	

private void searchByName() {
     System.out.println("---회원이름으로 검색---");
     System.out.print("검색할 회원명 입력 : ");
     String name = sc.nextLine();
     mc.searchByName(name);
}



private void searchById() {
 System.out.println("조회할 아이디: ");
 String id = sc.nextLine();
 
 mc.searchById(id);
}
/*
 * 회원추가를 위한 메뉴
 */
private void addMenu() {
 System.out.println("아이디 : ");
 String userId = sc.nextLine();
 
 System.out.println("비밀번호 : ");
 String userPw = sc.nextLine();
 
 System.out.println("이름 : ");
 String name = sc.nextLine();
 
 System.out.println("성별 (M/F) : ");
 char gender = sc.nextLine().toUpperCase().charAt(0);
 
 //회원추가 요청--> controller에게 요청
 mc.insertMember(userId, userPw, name, gender);
}
//-----------------------------응답용
/*
 * 성공했을 때 표시할 화면
 */
public void displaySuccess(String message) {
	
System.out.println("서비스 요청 성공 : " + message);

}
/**
 * 조히결과가 없을 때 사용자에게 표시할 화면
 * message 조회 결과에 메시지
 * 
 */
public void displayFailed(String message) {
	
System.out.println("서비스 요청 실패 : " + message);

}
public void displayNodata(String string) {
	
}
/**
 * 조회 결과가 여러행일때 사용자에게 표시할 화면
 * list 조회된 회원정보가 담겨 있는 리스트
 */
public void displayMemberList(ArrayList<Member> list) {
	System.out.println("-----조회결과-----");
	for(Member m : list) {
		System.out.println(m/*toString*/);
	}
}
/**
 * 조회결과 Member 객체를 화면에 표시
 * m
 */

public void displayMember(Member m) {
	System.out.println("--------조회결과---------");
	System.out.println(m);
    }

private void deleteMember() {
	System.out.println(" 삭제할 아이디 : ");
	String id = sc.nextLine();
    
	mc.deleteById(id);
	
}
private void updateMenu() {
System.out.println("----------회원정보 수정----------");
System.out.print("회원 아이디 : ");
String id = sc.nextLine();
System.out.print("변경할 비밀번호: ");
String pwd = sc.nextLine();
System.out.print("변경할 이름");
String name = sc.nextLine();
System.out.print("변경할 주소: ");
String addr = sc.nextLine();
System.out.print("변경할 연락처: ");
String phone = sc.nextLine();
System.out.print("변경할 취미: ");
String hobby = sc.nextLine();
	

//컨트롤러에게 입력받은 값 전달(=>회원정보 수정 요청)
mc.updateById(id, pwd, name, addr, phone, hobby);

}
}









