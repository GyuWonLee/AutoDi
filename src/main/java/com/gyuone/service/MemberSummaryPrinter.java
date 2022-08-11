package com.gyuone.service;

import com.gyuone.model.Member;

public class MemberSummaryPrinter extends MemberPrinter {

	@Override
	public void print(Member member) {
		// TODO Auto-generated method stub
		System.out.printf("회원정보 : 이메일=%s, 이름=%s\n", member.getEmail(), member.getName());
	}

}
