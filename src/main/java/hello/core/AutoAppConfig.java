package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 클래스들을 찾아 모두 스프링 빈으로 등록해준다.
@ComponentScan(
        // 컴포넌트 스캔 시작 위치를 지정할 수 있다.
        // basePackages = "hello.core.member",
        // AppConfig 등록되면 안되니까(충돌 나니까) 뺀다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
/*    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}


