package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @Test
    @DisplayName("Member 생성")
    void test01() {
        Member member = new Member("rang");

        assertThat(member).isEqualTo(new Member("rang"));
    }

    @Test
    @DisplayName("이름이 5글자 초과하면 에러 발생")
    void test02() {
        assertThatThrownBy(() -> new Member("saerang")).isInstanceOf(IllegalArgumentException.class);
    }
}
