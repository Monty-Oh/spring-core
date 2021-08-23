package hello.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * MemberService 구현체,
 * 구현체가 하나만 있으면 Impl을 이름을 뒤에 붙이는게 관례다.
 */
@Component
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    // 구현 객체를 선택한다. 인터페이스 - 구현체 다형성 사용
    private final MemberRepository memberRepository;

//    @Autowired // ac.getBean(MemberRepository.class)
//    public MemberServiceImpl(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
