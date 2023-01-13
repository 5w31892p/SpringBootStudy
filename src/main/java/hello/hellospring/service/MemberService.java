package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberReository;

@Service
public class MemberService {

	// private final MemberReository memberReository = new MemoryMemberRepository();
	// 같은 리포지토리로 테스트 해야하기 때문에 아래와 같이 변경
	private final MemberReository memberReository;

	@Autowired
	public MemberService(MemberReository memberReository) {
		this.memberReository = memberReository;
	}

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
