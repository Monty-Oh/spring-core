package hello.core.singletone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService statefulSerice1 = ac.getBean(StateFulService.class);
        StateFulService statefulSerice2 = ac.getBean(StateFulService.class);

        //ThreadA: A사용자 10000원 주문
        statefulSerice1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        statefulSerice2.order("userB", 20000);

//        assertThat(priceA).isNotSameAs(priceB);

        // ThreadA: 사용자A가 주문금액을 조회
        int price = statefulSerice1.getPrice();
        System.out.println("price = " + price);
        assertThat(statefulSerice1.getPrice()).isEqualTo(20000);
    }

    static class  TestConfig {
        @Bean
        public StateFulService stateFulService() {
            return new StateFulService();
        }
    }
}