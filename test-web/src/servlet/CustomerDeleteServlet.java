package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CustomerService;

@WebServlet("/delete.action")
public class CustomerDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 로그인 여부 확인 (로그인 하지 않은 경우 -> 로그인 화면으로 이동)		
//		  HttpSession session = req.getSession(); 
//		  Member member = (Member)session.getAttribute("loginuser"); 
//		  if (member == null) {
//			  resp.sendRedirect("/demoweb/account/login.action"); return; 
//		  }
		
		//2. 삭제 대상 글 번호 읽기
		String sCustomer_No = req.getParameter("customer_No");
		int customer_No = -1;
		try {
			customer_No = Integer.parseInt(sCustomer_No); //문자열 -> 숫자
		} catch (Exception ex) { // 자료 번호에 문제가 있는 경우
			resp.sendRedirect("home.action");
			return;
		}
		
		//3. 서비스 객체에 삭제 요청
		CustomerService customerService = new CustomerService();
		customerService.delete(customer_No);
		
		//4. 목록으로 이동
		resp.sendRedirect("home.action");
		 
		
	}

}







