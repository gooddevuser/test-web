package service;

import java.util.List;

import common.Util;
import dao.MemberDao;
import vo.Member;

public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public void registerMember(Member member) {
		
		// 패스워드 암호화
		String plainPasswd = member.getPasswd();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		member.setPasswd(hashedPasswd);
		
		memberDao.insertMember(member);
		
	}
	
	public Member login(String memberId, String passwd) {
		
		// 패스워드 암호화
		passwd = Util.getHashedString(passwd, "SHA-256");
		
		Member member = 
				memberDao.selectMemberByIdAndPasswd(memberId, passwd);
		return member;
	}

	public void updateMember(Member member) {
		
		// 패스워드 암호화
		String plainPasswd = member.getPasswd();
		String hashedPasswd = Util.getHashedString(plainPasswd, "SHA-256");
		member.setPasswd(hashedPasswd);
		
		memberDao.updateMember(member);
		
	}

	public List<Member> findAll() {
		List<Member> members = memberDao.selectMember();
		return members;
	}

}











