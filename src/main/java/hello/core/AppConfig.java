package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()를 호출한다.
    // 그런데 orderService에서 또 호출하므로 또 new MemoryMemberRepository()를 호출하게 된다.

    @Bean
    // 누군가 MemberService를 호출해서 사용할때 MemberServiceImpl 구현체가 반환된다.
    public MemberService memberService() {
        System.out.println("[Created Bean] AppConfig.memberService");
        // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("[Created Bean] AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        System.out.println("[Created Bean] AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
