<%@page import="com.edu.member.model.MemberVO"%>
<%@page import="com.edu.member.model.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 사용자 입력을 받아서 -> OracleDB에 저장 -> 처리결과(memberOutput.jsp)에 보여주도록 Service logic을 구현. 
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");

	MemberVO member = new MemberVO();
	member.setId(id);
	member.setPasswd(passwd);
	member.setName(name);
	member.setMail(mail);
	
	//서비스로직 (MemberService.java)
	// DB 처리 (MemberDAO.java)
	MemberService service = new MemberService();
	service.memberInsert(member);
	
	request.setAttribute("member", member);

	// 처리결과 (memberOutput.jsp)
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
	
%>