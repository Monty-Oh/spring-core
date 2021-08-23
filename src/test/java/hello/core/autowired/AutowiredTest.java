package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        // TestBean을 넣으면 스프링 빈으로 등록이 된다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
//        TestBean bean = ac.getBean(TestBean.class);
//        System.out.println("bean = " + bean);
    }

    @Component
    static class TestBean {
        // required가 false면 실행을 건너뛴다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        // 없다면 Null값이 온다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }
        // 없다면 Optional.empty가 할당된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
