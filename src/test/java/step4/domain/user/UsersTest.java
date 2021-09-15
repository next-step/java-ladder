package step4.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.user.UsersCountException;

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

    @Test
    @DisplayName("사다리 게임이 두명이상 들어오지 않을 때 Exception이 발생해야 한다.")
    void usersSizeExceptionTest() {

        // given
        String input = "pobi";

        // when & then
        assertThatExceptionOfType(UsersCountException.class)
            .isThrownBy(() -> Users.of(input))
            .withMessageMatching("사람의 수는 2명이상이 들어와야 한다.");
    }

}