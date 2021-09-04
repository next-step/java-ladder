package ladder.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import ladder.domain.ladder.LadderHeight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersTest {

    @Test
    @DisplayName("사람의 이름이 쉼표로 들어오면 사람 List를 생성할 수 있다.")
    void usersCreateByNameStringTest() {

        // given
        String input = "pobi,honux,crong,jk";
        List<User> users = Arrays.asList(
            new User("pobi"),
            new User("honux"),
            new User("crong"),
            new User("jk")
        );
        Users expected = new Users(users);

        // when
        Users result = Users.of(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사람의 수는 2명이상 들어오지 않으면 Exception이 발생되어야 한다.")
    void userCreateFailByUserCountTest() {

        // given
        String input = "test";

        // when
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Users.of(input))
            .withMessageMatching("사람의 수는 2명이상이 들어와야 한다.");
    }

}
