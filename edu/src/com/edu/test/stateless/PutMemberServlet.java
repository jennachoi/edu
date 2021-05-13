package com.edu.test.stateless;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberRegister")
public class PutMemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// db에서 리스트 => memberList.jsp로 포워딩
		MemberDAO dao = new MemberDAO();
		List<Member> list = dao.getMemberList();
		RequestDispatcher rd = req.getRequestDispatcher("memberList.jsp");
		req.setAttribute("memberList", list);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		// parameter를 읽어서 DB에 Insert하고, memberResult.jsp로 결과를 보여주기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String age = req.getParameter("age");


		// 값을 넣어주는 방법1 - 생성한 클래스 이용
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPwd(pwd);
		member.setMemberName(name);
		member.setMemberAge(Integer.parseInt(age));
		// 값을 넣어주는 방법2 - 오브젝트 타입으로 넣기 
//		req.setAttribute("id", id); 
//		req.setAttribute("pwd", pwd);
//		req.setAttribute("name", name); 

		MemberDAO dao = new MemberDAO();
		dao.insertMember(member);
		System.out.println("db에 입력되었습니다.");

		// this.getServletContext(); // ServletContext가 가지고있는 requestDispatcher를 객체를 호출하기 위해서
		RequestDispatcher rd = req.getRequestDispatcher("memberResult.jsp");
		req.setAttribute("member", member);
		rd.forward(req, resp); 
		// RequestDispatcher : request가 가지고 있는 값을 저장 -> 요청정보와 응답정보를 그대로 가지고 forwarding
	}
}
