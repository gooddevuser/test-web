package service;
import java.util.List;

import common.Util;
import dao.AccountDao;
import vo.Account;

public class AccountService {
	private AccountDao accountDao = new AccountDao();
	public void writeAccount(Account account) {		
		//AccountDao 객체에게 데이터 저장 요청
		//AccountDao.insertAccount(Account);		
		int newAccount_No = accountDao.insertAccount(account);
		
			//title, uploader, content, uploadno(자동생산)
	}
	public List<Account> findAll() {
		List<Account> accounts = accountDao.selectAccount();
		return accounts;
	}
	public void delete(int customer_No) {
		accountDao.deleteAccount(customer_No);
		
	}
	public Account findByCustomer_No(int customer_No) {
		// UploadDao 객체에게 데이터 조회 요청
		Account account = accountDao.selectAccountByCustomer_No(customer_No);
		
		return account;
	}
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);		
	}
}