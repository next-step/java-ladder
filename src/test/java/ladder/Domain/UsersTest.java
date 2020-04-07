package ladder.Domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest {

    @ParameterizedTest
    @CsvSource(value = {"0 true:1", "1 true:2", "2 true:3", "3 true:2", "1 false:1"}, delimiter = ':')
    void positionMoveTest(String input, String expected) {
        String[] inputs = input.split(" ");
        int userCount = 4;
        Position position = Position.of(Integer.parseInt(inputs[0]), userCount);
        position = position.crossWay(Boolean.parseBoolean(inputs[1]));

        assertThat(position).isEqualTo(Position.of(Integer.parseInt(expected), userCount));
    }

    @Test
    void userTest() {
        int userCount = 4;
        User user = User.of("pobi", position, userCount);

        assertThat(user).isEqualTo(User.of("pobi", position, userCount));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk"}, delimiter = ':')
    void usersTest(String input, String expected) {
        MoveStrategy moveStrategy = () -> true;
        Users users = Users.of(input, moveStrategy);

        Position position = Position(0);
        int userCount = 4;

        assertThat(users.toList())
                .hasSize(4)
                .contains(User.of("pobi", position, userCount));
    }
}
