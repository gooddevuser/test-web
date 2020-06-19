package vo;

import lombok.Data;

//데이터베이스의 Member 테이블의 데이터를 저장하는 클래스
@Data // 자동으로 getter, setter, constructor, ... 을 만드는 어노테이션
public class Customer {
	
	//필드 선언은 테이블의 컬럼과 일치하도록 구현
	private int customer_No;
	private String customerName;
	private String customerStreet;
	private String customerCity;
	private boolean deleted; // 자료의 삭제 여부
	
	//List<Account> accounts = new List<Account>(); 
	
}
