package hello.core.singletone;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    void configuratioNTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 테스트 용도로 생성한 메소드를 호출하기 위해 구체로 꺼낸다. (이렇게 하면 좋은 방법이 아님.)
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        // 본체. 진짜 MemoryRepository
        MemberRepository memberRepository = ac.getBean("memberRepository", MemoryMemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService = " + memberRepository1);
        System.out.println("orderService = " + memberRepository2);

        /**
         * @Configuration AppConfig에서 new MemoryMemberRepository 호출로 인해
         * 다른 객체를 전달받는 것 같지만, 같은 객체를 가리켜고 있다.
         * */
        assertThat(memberRepository1).isSameAs(memberRepository2);

        /**
         * 세개 다 같은 객체를 가리켜고 있다.
         * */
        assertThat(memberRepository).isSameAs(memberRepository2);
    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
