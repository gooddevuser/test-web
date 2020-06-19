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

@WebServlet("/accountadd.action")
public class AccountAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/accountadd.jsp");
		dispatcher.forward(request, response);
	}
	
	// 폼태그에서 post 를 사용해서 dopost를 쓴다.
	
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 데이터 읽기
		
		req.setCharacterEncoding("utf-8"); // post 방식 때는 한글 처리를 위해 항상 작성하는 코드
				// req.getParameter(name) : 사용자가 보낸 데이터를 읽기 id X name O
//		String branchName = req.getParameter("branchname");
//		String accountNumber = req.getParameter("accounnumber");
//				
//		// 2. 처리	private int customer_No;
//
//		// System.out.printf("[%s][%s][%s]", memberId, passwd, email);
//		Account account = new Account();
//		account.setBranchName(branchName);
//		account.setAccountNumber(accountNumber);
//				
//		AccountService accountService = new AccountService(); // 서블릿에서 서비스로 넘어간다.
//		accountService.writeAccount(account);
//				
		// 3. 홈으로 이동
//		resp.sendRedirect("/test-web/home.action");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/accountadd.jsp");
		dispatcher.forward(req, resp);
	} 
}