package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(String name, int initPos) {
        assertThat(new User(name, initPos)).isEqualTo(new User(name, initPos));
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of("pobi", 0),
                Arguments.of("honux", 1),
                Arguments.of("crong", 2),
                Arguments.of("jk", 3)
        );
    }
}
