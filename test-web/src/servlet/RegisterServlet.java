package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
	}
	
	// 폼태그에서 post 를 사용해서 dopost를 쓴다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 데이터 읽기
				req.setCharacterEncoding("utf-8"); // post 방식 때는 한글 처리를 위해 항상 작성하는 코드
				// req.getParameter(name) : 사용자가 보낸 데이터를 읽기 id X name O
				String memberId = req.getParameter("memberId");
				String passwd = req.getParameter("passwd");
				String email = req.getParameter("email");
				
				// 2. 처리
				// System.out.printf("[%s][%s][%s]", memberId, passwd, email);
				Member member = new Member();
				member.setMemberId(memberId);
				member.setPasswd(passwd);
				member.setEmail(email);
				
				MemberService memberService = new MemberService();
				memberService.registerMember(member);
				
				// 3. 홈으로 이동
				resp.sendRedirect("/test-web/home.action");
		
	}
}