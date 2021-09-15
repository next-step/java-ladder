package step4.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UsersTest {

    @Test
    @DisplayName("사람 이름이 모인 String을 가지고 Users를 생성할 수 있다.")
    void createUsersTest() {

        // given
        String input = "pobi,honux,crong,jk";
        List<User> users = Arrays.asList(
            User.of("pobi"),
            User.of("honux"),
            User.of("crong"),
            User.of("jk")
        );
        Users expected = Users.of(users);

        // when
        Users result = Users.of(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}