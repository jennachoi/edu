package com.edu.member.model;

public class MemberService {
	
	//처리하는 로직을 구현 
	//입력, 조회, 수정, 삭제 기능 구현 (실제파일, DB에 저장 X)
	
	MemberDAO dao = new MemberDAO();
	
	public void memberInsert(MemberVO member){
		dao.insertMember(member);
	}
}
