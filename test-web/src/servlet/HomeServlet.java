package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import vo.Customer;



@WebServlet("/home.action")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 2. 자료실 목록 조회 (서비스 객체에 요청)
		CustomerService customerService = new CustomerService();
		List<Customer> customers = customerService.findAll();
		
		// 3. JSP에서 사용할 수 있도록 조회된 데이터를 request 객체에 저장
		request.setAttribute("customers", customers);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		dispatcher.forward(request, response);
	}

}
