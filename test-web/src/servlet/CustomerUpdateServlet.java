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
import vo.Customer;
@WebServlet("/customerupdate.action")
public class CustomerUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 로그인 여부 확인 (로그인 하지 않은 경우 -> 로그인 화면으로 이동)
		/*
		 * HttpSession session = req.getSession(); Member member =
		 * (Member)session.getAttribute("loginuser"); if (member == null) {
		 * resp.sendRedirect("/demoweb/account/login.action"); return; }
		 */
		// 2. 사용자가 선택한 자료 번호 읽기
		String sCustomer_No = req.getParameter("customer_No");
		int customer_No = -1;
		try {
			customer_No = Integer.parseInt(sCustomer_No);
		} catch (Exception e) { // 잘못된 자료번호인 경우
			resp.sendRedirect("home.action"); // 목록으로 이동
			return;
		}

		// 3. 사용자가 선택한 자료 정보 조회 (서비스 객체에 요청)
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.findByCustomer_No(customer_No);

		if (customer == null) { // 조회 실패
			resp.sendRedirect("home.action");
			return;
		}

		// 5. JSP에서 사용할 수 있도록 조회된 데이터를 request 객체에 저장
		req.setAttribute("customer", customer);

		// 6. JSP로 forward
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customerupdate.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		String sCustomer_No = req.getParameter("customer_No");
		
		int customer_No = -1;
		try {
			customer_No = Integer.parseInt(sCustomer_No);
		} catch (Exception e) { // 잘못된 자료번호인 경우
			resp.sendRedirect("home.action"); // 목록으로 이동
			return;
		}
		String customerStreet = req.getParameter("customerStreet");
		String customerCity = req.getParameter("customerCity");
		
		
		// 3-1. 읽은 데이터를 Upload 객체에 저장
		Customer customer = new Customer();
		customer.setCustomer_No(customer_No);
		customer.setCustomerStreet(customerStreet);
		customer.setCustomerCity(customerCity);
		
		// 3-2. 서비스 객체에 처리 요청 (이 때 Upload 객체 전달 인자로 메소드 호출)
		CustomerService customerService = new CustomerService();
		customerService.updateCustomer(customer);
		
		// 4. 목록 화면으로 이동
		resp.sendRedirect("home.action");

}
}













