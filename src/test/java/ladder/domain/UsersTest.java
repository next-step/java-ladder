package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UsersTest {

    @ParameterizedTest
    @MethodSource("countArgs")
    void countTest(String[] names, int expected) {
        assertThat(new Users(names).count()).isEqualTo(expected);
    }

    static Stream<Arguments> countArgs() {
        return Stream.of(
            Arguments.of(new String[]{"a"}, 1),
            Arguments.of(new String[]{"a", "b"}, 2)
        );
    }
}
