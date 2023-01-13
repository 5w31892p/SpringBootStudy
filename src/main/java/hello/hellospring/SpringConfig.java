package hello.hellospring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberReository;
import hello.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	private final DataSource dataSource;
	public SpringConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	@Bean
	public MemberReository memberRepository() {
		// return new MemoryMemberRepository();
		return new JdbcMemberRepository(dataSource);
	}
}
