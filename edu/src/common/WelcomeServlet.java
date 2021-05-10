package common;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	// Servlet (Interface) => GenericServlet => HttpServlet => FirstServlet
	// 					   상속 	  추상클래스 	상속 		클래스

	// init 메소드 실행 -> service 메소드 호출 -> destroy(소멸자)

	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");
	}

//	@Override
//	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		System.out.println("service(1)");
//		doGet(req, res); // get메소드 호출
//		
//
//	}
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service(2)");
//	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
