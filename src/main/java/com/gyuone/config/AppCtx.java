package com.gyuone.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.gyuone.dao.MemberDao;
import com.gyuone.service.ChangePasswordService;
import com.gyuone.service.MemberInfoPrinter;
import com.gyuone.service.MemberListPrinter;
import com.gyuone.service.MemberPrinter;
import com.gyuone.service.MemberRegisterService;
import com.gyuone.service.MemberSummaryPrinter;
import com.gyuone.service.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"com.gyuone"},
excludeFilters = @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value = {AppConf1.class, AppConf2.class, AppConfImport.class })
) // 지우지 않고 없애버리기 포함시키지 않음
public class AppCtx {

//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
//
//	@Bean
//	public MemberRegisterService memberRegSvc() { // MemberRegisterService의 식별자는 memberRegSvc
////		return new MemberRegisterService(memberDao());
//		return new MemberRegisterService();
//	}
//	
//	@Bean
//	public ChangePasswordService changePwdSvc() {
//		ChangePasswordService pwdSvc = new ChangePasswordService();
////		pwdSvc.setMemberDao(memberDao()); 필드에다가 Autowired 적용하면 안해도 된다.
//		return pwdSvc;
//	}
//	
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("summaryPrinter")
	public MemberPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
//	@Bean
//	public MemberListPrinter listPrinter() {
////		return new MemberListPrinter(memberDao(), memberPrinter());
//		return new MemberListPrinter();
//	}
	
//	@Bean
//	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
////		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter2()); //spring이 알아서 호출 autowired
//		return infoPrinter;
//	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
}
