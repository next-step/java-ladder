package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Nested
    class toString_메서드는 {

        @Test
        void 이름을_리턴한다() {
            String name = "name";

            Member member = new Member(name);

            assertThat(member.toString()).isEqualTo(name);
        }
    }
}
