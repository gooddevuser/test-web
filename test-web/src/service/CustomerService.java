package service;
import java.util.List;

import common.Util;
import dao.CustomerDao;
import vo.Customer;

public class CustomerService {
	private CustomerDao customerDao = new CustomerDao();
	public void writeCustomer(Customer customer) {		
		//CustomerDao 객체에게 데이터 저장 요청
		//customerDao.insertCustomer(customer);		
		int newCustomer_No = customerDao.insertCustomer(customer);
		
			//title, uploader, content, uploadno(자동생산)
	}
	public List<Customer> findAll() {
		List<Customer> customers = customerDao.selectCustomer();
		return customers;
	}
	public void delete(int customer_No) {
		customerDao.deleteCustomer(customer_No);
		
	}
	public Customer findByCustomer_No(int customer_No) {
		// UploadDao 객체에게 데이터 조회 요청
		Customer customer = customerDao.selectCustomerByCustomer_No(customer_No);
		
		return customer;
	}
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);		
	}
}