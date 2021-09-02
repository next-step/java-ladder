package ladder.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

}
