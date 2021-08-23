package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void VIP_정률_할인() {
        // Given
        Member member = new Member(1L, "memberVip", Grade.VIP);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        // Then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void BASIC_정률_할인() {
        // Given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        // Then
        Assertions.assertThat(discount).isNotEqualTo(1000);
    }
}