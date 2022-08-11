package com.gyuone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.gyuone.dao.MemberDao;
import com.gyuone.model.Member;

@Component("infoPrinter") // 소문자를 바꾼이름으로 주게 되는데 특별한 이름으로 지정해주고 싶을 때 식별자를 준다. 준 이름으로 등록함.
public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}
}