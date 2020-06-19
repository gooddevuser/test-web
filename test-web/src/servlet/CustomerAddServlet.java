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

import service.CustomerService;
import vo.Customer;

@WebServlet("/customeradd.action")
public class CustomerAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customeradd.jsp");
		dispatcher.forward(request, response);
	}
	
	// 폼태그에서 post 를 사용해서 dopost를 쓴다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 데이터 읽기
		req.setCharacterEncoding("utf-8"); // post 방식 때는 한글 처리를 위해 항상 작성하는 코드
				// req.getParameter(name) : 사용자가 보낸 데이터를 읽기 id X name O
		String customerName = req.getParameter("customername");
		String customerStreet = req.getParameter("customerstreet");
		String customerCity = req.getParameter("customercity");
				
		// 2. 처리
		// System.out.printf("[%s][%s][%s]", memberId, passwd, email);
		Customer customer = new Customer();
		customer.setCustomerName(customerName);
		customer.setCustomerStreet(customerStreet);
		customer.setCustomerCity(customerCity);
				
		CustomerService customerService = new CustomerService(); // 서블릿에서 서비스로 넘어간다.
		customerService.writeCustomer(customer);
				
		// 3. 홈으로 이동
		resp.sendRedirect("/test-web/home.action");
		
	}
}