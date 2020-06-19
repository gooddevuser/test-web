package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Customer;
public class CustomerDao {
	public int insertCustomer(Customer customer) {
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
				"INSERT INTO CUSTOMER (customer_no, customername, customerstreet, customercity) " +
				"VALUES (CUSTOMER_SEQUENCE.NEXTVAL,?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerStreet());
			pstmt.setString(3, customer.getCustomerCity());
			
			//4. 명령 실행
			pstmt.executeUpdate(); // insert, update, delete를 위한 메서드
			
			//********************************************
			// insert된 자료의 자동증가 자료번호 조회
			sql = "SELECT CUSTOMER_SEQUENCE.CURRVAL FROM DUAL";
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

	public List<Customer> selectCustomer() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //조회 결과를 참조하는 변수
		
		// 조회 결과를 저장할 변수
		ArrayList<Customer> customers = new ArrayList<>(); 
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			//3. SQL 작성 + 명령 만들기
			String sql = 
					"SELECT customer_no,customername, customerstreet, customercity, deleted " +
					"FROM CUSTOMER " +
					//"WHERE deleted = '0'" + // 삭제된 글은 조회하지 않기
					"ORDER BY customer_no DESC";
			pstmt = conn.prepareStatement(sql);
			
			//4. 명령 실행
			rs = pstmt.executeQuery(); // select를 위한 메서드
			
			//5. 결과가 있다면 결과 처리 (select)
			while (rs.next()) { //조회된 데이터가 있다면
				//조회된 데이터를 Upload 객체에 저장
				Customer customer = new Customer();
				customer.setCustomer_No(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerStreet(rs.getString(3));
				customer.setCustomerCity(rs.getString(4));
				customer.setDeleted(rs.getBoolean(5));
				
				//한 건의 데이터를 데이터 목록에 추가
				customers.add(customer); 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return customers; //조회된 데이터 목록을 저장한 리스트 객체 반환
	}
	public Customer selectCustomerByCustomer_No(int customer_No) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //조회 결과를 참조하는 변수
		
		// 조회 결과를 저장할 변수
		Customer customer = null; 
		
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. 연결 만들기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",// 연결 정보
					"testweb", "9922"); //계정 정보
			
			//3. SQL 작성 + 명령 만들기
			String sql = 
					"SELECT customer_no, customername, customerstreet, customercity, deleted " +
					"FROM CUSTOMER " +
					"WHERE customer_no = ? AND deleted = '0'";					
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customer_No);
			
			//4. 명령 실행
			rs = pstmt.executeQuery(); // select를 위한 메서드
			
			//5. 결과가 있다면 결과 처리 (select)
			if (rs.next()) { //조회된 데이터가 있다면
				//조회된 데이터를 Upload 객체에 저장
				customer = new Customer();
				customer.setCustomer_No(rs.getInt(1));
				customer.setCustomerName(rs.getString(2));
				customer.setCustomerStreet(rs.getString(3));
				customer.setCustomerCity(rs.getString(4));
				customer.setDeleted(rs.getBoolean(5));				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return customer; //조회된 데이터를 저장한 객체 반환
	}
	
	public void deleteCustomer(int customer_No) {
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
			String sql = "UPDATE CUSTOMER SET deleted = '1' WHERE customer_no = ?";
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

	
	public void updateCustomer(Customer customer) {
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
				"UPDATE CUSTOMER " +
				"SET customerstreet = ?, customercity = ? " +
				"WHERE customer_no = ?";
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, customer.getCustomerStreet());
			pstmt.setString(2, customer.getCustomerCity());
			pstmt.setInt(3, customer.getCustomer_No());			
			
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
