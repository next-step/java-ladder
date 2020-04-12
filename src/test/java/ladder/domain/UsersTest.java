package ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class UsersTest {

    @ParameterizedTest
    @CsvSource(value = {"0 1:1", "1 1:2", "2 1:3", "3 -1:2", "1 0:1"}, delimiter = ':')
    void positionMoveTest(String input, String expected) {
        String[] inputs = input.split(" ");
        Position position = Position.of(Integer.parseInt(inputs[0]));
        SteerRule steerRule = SteerRule.direction(Integer.parseInt(inputs[1]));

        position = position.crossWay(steerRule);

        assertThat(position).isEqualTo(Position.of(Integer.parseInt(expected)));
    }

    @Test
    void userTest() {
        Position position = Position.of(0);
        User user = User.of("pobi", position);

        assertThat(user).isEqualTo(User.of("pobi", position));
    }

    @Test
    void usersTest() {
        Users users = Users.of("pobi,honux,crong,jk");

        Position position = Position.of(0);

        assertThat(users.toList())
                .hasSize(4)
                .contains(User.of("pobi", position));
    }

    @Test
    void zeroUsersTest() {
        assertThatExceptionOfType(MinimumUserException.class).isThrownBy(() -> {
            Users.of("");
        });
    }

    @Test
    void userNameTest() {
        Position position = Position.of(0);
        User user = User.of("pobi", position);

        assertThat(user.getName()).isEqualTo("pobi");
    }

    @Test
    void findUserByNameTest() {
        Users users = Users.of("pobi,honux,crong,jk");
        Position position = Position.of(0);

        User user = users.findUserByName("pobi");

        assertThat(user).isEqualTo(User.of("pobi", position));
    }

    @Test
    void notFoundUserByNameExceptionTest() {
        Users users = Users.of("pobi,honux,crong,jk");

        assertThatExceptionOfType(notFoundUserByNameException.class).isThrownBy(() -> {
            users.findUserByName("noUser");
        });
    }
}
