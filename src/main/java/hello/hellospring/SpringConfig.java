package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberReository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	private final MemberReository memberReository;

	public SpringConfig(MemberReository memberReository) {
		this.memberReository = memberReository;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberReository);
	}
	// @Bean
	// public MemberReository memberRepository() {
	// 	// return new MemoryMemberRepository();
	// 	// return new JdbcMemberRepository(dataSource);
	// 	// return new JdbcTemplateMemberRepository(dataSource);
	// 	return new JpaMemberRepository(em);
	// }
}
