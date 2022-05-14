package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MembersTest {

    @Nested
    class toString_메서드는 {

        @Test
        void 이름_목록을_리턴한다() {
            Members members = Members.of(Arrays.asList("pobi", "jason", "pang", "nem"));

            assertThat(members.toString()).isEqualTo("[pobi, jason, pang, nem]");
        }

    }
}
