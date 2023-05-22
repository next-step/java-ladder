package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class UserTest {


    public static Stream<Arguments> preparingUserAndLadder() {
        return Stream.of(
                Arguments.of(new User("test", 0), Ladder.createLadder(1, 5, () -> true), 0),
                Arguments.of(new User("test", 0), Ladder.createLadder(5, 5, () -> true), 1),
                Arguments.of(new User("test", 4), Ladder.createLadder(5, 5, () -> true), 4),
                Arguments.of(new User("test", 3), Ladder.createLadder(1000, 200, () -> false), 3)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "preparingUserAndLadder")
    void rideLadder(User user, Ladder ladder, int lastPosition) {
        User afterRiding = user.rideLadder(ladder);
        Assertions.assertThat(afterRiding.getPosition()).isEqualTo(lastPosition);
        Assertions.assertThat(afterRiding.getName()).isEqualTo(user.getName());
    }

    @ParameterizedTest
    @CsvSource(value = {
            "tooLong",
            "abcdef",
            "all"
    })
    void nameTest(String name) {
        Assertions.assertThatThrownBy(() -> new User(name, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}