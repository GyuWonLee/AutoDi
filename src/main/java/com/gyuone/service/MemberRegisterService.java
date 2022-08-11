package com.gyuone.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gyuone.common.DuplicateMemberException;
import com.gyuone.dao.MemberDao;
import com.gyuone.model.Member;
import com.gyuone.model.RegisterRequest;

@Component
public class MemberRegisterService {
//	private MemberDao memberDao = new MemberDao(); // 강한 결합
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { // MemberDao를 받는 기본 생성자 
	}
	
	public MemberRegisterService(MemberDao memberDao) { // 생성자를 통해서 의존을 주입.. 생성자 의존 주입 = DI
		this.memberDao = memberDao;
	}
	
	public long register(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newmember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newmember);
		return newmember.getId();
	}
}
