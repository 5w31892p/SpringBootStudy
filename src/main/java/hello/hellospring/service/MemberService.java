package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {

	private final MemberReository memberReository = new MemoryMemberRepository();

	public Long join(Member member) {
		validateDuplicateMember(member);
		memberReository.save(member);
		return member.getId();
	}

	public void validateDuplicateMember(Member member) {
		memberReository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다.");
			});
	}

	public List<Member> findMember() {
		return memberReository.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return memberReository.findById(memberId);
	}

}
