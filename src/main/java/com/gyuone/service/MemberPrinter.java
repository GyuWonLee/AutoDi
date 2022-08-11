package com.gyuone.service;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.gyuone.model.Member;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", member.getId(),
					member.getEmail(), member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("회원정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", member.getId(),
					member.getEmail(), member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}

	@Autowired(required = false) // 필수가 아니다. default는 true
	public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}

	
	
	
	
}
