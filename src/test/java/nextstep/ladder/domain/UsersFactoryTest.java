package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UsersFactoryTest {

    @Nested
    class create_메서드는 {

        @Nested
        class 유저이름_문자열이_주어지면 {

            @Test
            void Users를_리턴한다() {
                Users users = UsersFactory.create("pobi,jason,pang,nem");

                assertThat(users).isInstanceOf(Users.class);
            }
        }
    }
}
