package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    @DisplayName("Member 생성")
    void test01() {
        Member member = new Member("rang");

        assertThat(member.name()).isEqualTo("rang");
    }
}
