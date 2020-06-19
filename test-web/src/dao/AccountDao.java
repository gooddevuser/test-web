package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Account;
import vo.Customer;
public class AccountDao {
	public int insertAccount(Account account) {
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		int newCustomer_No = -1;		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			//3. SQL 작성 + 명령 만들기
			String sql = 
				"INSERT INTO ACCOUNT (customer_No, branchname, accountnumber, balance) " +
				"VALUES (? ,?, ?, ?)" +
				"FROM ACCOUNT";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account.getCustomer_No());
			pstmt.setString(2, account.getBranchName());
			pstmt.setString(3, account.getAccountNumber());
			pstmt.setInt(4, account.getBalance());
			
			//4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete를 위한 메서드
			
			//********************************************
			// insert된 자료의 자동증가 자료번호 조회
			sql = "SELECT ACCOUNT_SEQUENCE.CURRVAL FROM DUAL";
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			
			//5. 결과가 있다면 결과 처리 (select)
			rs.next();
			newCustomer_No = rs.getInt(1);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return newCustomer_No;
				
	}

	public List<Account> selectAccount() {
		
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //조회 결과를 참조하는 변수
		
		// 조회 결과를 저장할 변수
		ArrayList<Account> accounts = new ArrayList<>(); 
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			//3. SQL 작성 + 명령 만들기
			String sql = 				
					"SELECT c.customer_No, c.customerName, c.customerStreet, c.customerCity, a.customer_No , a.branchname, a.accountnumber, a.balance, a.deleted " +
					"FROM ACCOUNT A INNER JOIN CUSTOMER C " +
					"ON a.customer_No = c.customer_No";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행
			rs = pstmt.executeQuery(); // select를 위한 메서드
			//5. 결과가 있다면 결과 처리 (select)
			while (rs.next()) { //조회된 데이터가 있다면
				//조회된 데이터를 Upload 객체에 저장
				Account account = new Account();
				account.setCustomer_No(rs.getInt(5));
				account.setBranchName(rs.getString(6));
				account.setAccountNumber(rs.getString(7));
				account.setBalance(rs.getInt(8));
				account.setDeleted(rs.getBoolean(9));
				Customer customer = new Customer();
				customer.setCustomer_No(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerStreet(rs.getString(3));
				customer.setCustomerCity(rs.getString(4));				
				account.setCustomer(customer);
				
				//한 건의 데이터를 데이터 목록에 추가
				accounts.add(account); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return accounts; //조회된 데이터 목록을 저장한 리스트 객체 반환
	}
	public Account selectAccountByCustomer_No(int customer_No) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null; //조회 결과를 참조하는 변수
//		
//		// 조회 결과를 저장할 변수
		Account account = null; 
//		
//		try {
//			//1. 드라이버 등록
//			Class.forName("oracle.jdbc.OracleDriver");
//			
//			//2. 연결 만들기
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
//					"testweb", "9922"); //계정 정보
//			
//			//3. SQL 작성 + 명령 만들기
//			String sql = 
//					"SELECT c.customer_No, a.branchname, a.accountnumber, a.balance, a.deleted " +
//					"FROM ACCOUNT A INNER JOIN CUSTOMER C " +
//					"ON a.customer_No = c.customer_No " +
//					"WHERE customer_No = ? AND deleted = '0'";					
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, customer_No);
//			
//			//4. 명령 실행
//			rs = pstmt.executeQuery(); // select를 위한 메서드
//			
//			//5. 결과가 있다면 결과 처리 (select)
//			if (rs.next()) { //조회된 데이터가 있다면
//				//조회된 데이터를 Upload 객체에 저장
//				Account account = new Account();
//				account.setBranchName(rs.getString(2));
//				account.setAccountNumber(rs.getString(3));
//				account.setBalance(rs.getInt(4));
//				account.setDeleted(rs.getBoolean(5));
//				Customer customer = new Customer();
//				customer.setCustomer_No(rs.getInt(1));
//				account.setCustomer_No(customer);			
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			//6. 연결 종료
//			try { rs.close(); } catch (Exception ex) {}
//			try { pstmt.close(); } catch (Exception ex) {}
//			try { conn.close(); } catch (Exception ex) {}
//		}
		
		return account; //조회된 데이터를 저장한 객체 반환
	}
	
	public void deleteAccount(int customer_No) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			
			//3. SQL 작성 + 명령 만들기
			//String sql = "DELETE FROM UPLOAD WHERE uploadno = ?";
			String sql = "UPDATE ACCOUNT SET deleted = '1' WHERE customer_No = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_No);
			
			//4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete를 위한 메서드
			
			//5. 결과가 있다면 결과 처리 (select)
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
	}

	
	public void updateAccount(Account account) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			//3. SQL 작성 + 명령 만들기
			String sql = 
				"UPDATE ACCOUNT " + 
				"SET branchname = ?, accountnumber = ? , balance = ? " +
				"WHERE customer_No = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, account.getCustomer_No());
			pstmt.setString(2, account.getBranchName());
			pstmt.setString(3, account.getAccountNumber());	
			pstmt.setInt(4, account.getBalance());	
			
			//4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete를 위한 메서드
			
			//5. 결과가 있다면 결과 처리 (select)
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}
}
