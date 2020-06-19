package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AccountService;
import vo.Account;

@WebServlet("/accountdetail.action")
public class AccountDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 로그인 여부 확인 (로그인 하지 않은 경우 -> 로그인 화면으로 이동)
		/*
		 * HttpSession session = req.getSession(); Member member =
		 * (Member)session.getAttribute("loginuser"); if (member == null) {
		 * resp.sendRedirect("/account/login.action"); return; }
		 */
		// 2. 사용자가 선택한 자료 번호 읽기
		String sCustomer_No = request.getParameter("customer_No");
		int customer_No = -1;
		try {
			customer_No = Integer.parseInt(sCustomer_No);
		} catch (Exception e) { // 잘못된 자료번호인 경우
			response.sendRedirect("/test-web/home.action"); // 목록으로 이동
			return;
		}
		
		// 3. 사용자가 선택한 자료 정보 조회 (서비스 객체에 요청)
		AccountService accountService = new AccountService();
		Account account = accountService.findByCustomer_No(customer_No);		
		
		if (account == null) { // 조회 실패
			response.sendRedirect("/test-web/home.action");
			return;
		}
		
		// 4. JSP에서 사용할 수 있도록 조회된 데이터를 request 객체에 저장
		request.setAttribute("account", account);
		
		// 5. JSP로 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/accountdetail.jsp");
		dispatcher.forward(request, response);
	}

}
