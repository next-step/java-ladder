package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UsersTest {

    @Nested
    class toString_메서드는 {

        @Test
        void 유저이름_목록을_리턴한다() {
            Users users = Users.of(Arrays.asList("pobi", "jason", "pang", "nem"));

            assertThat(users.toString()).isEqualTo("[pobi, jason, pang, nem]");
        }

    }
}
