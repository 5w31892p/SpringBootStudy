package hello.hellospring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {

	// MemoryMemberRepository memberRepository = new MemoryMemberRepository();
	MemberService memberService;
	MemoryMemberRepository memberRepository;

	@BeforeEach
	public void beforEach() {
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);

	}

	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}

	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("hello");
		// when
		Long saveId = memberService.join(member);
		// then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복확인() {
		//given
		Member member1 = new Member();
		member1.setName("spring");

		Member member2 = new Member();
		member2.setName("spring");
		//when

		/**
		memberService.join/*(member1);
		memberService.join(member2);*/

		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class,
			() -> memberService.join(member2));
		//then
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

	}

	@Test
	void 전체조회() {
		//given
		//when
		//then
	}

	@Test
	void 한명조회() {
	}
}