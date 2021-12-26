package nextstep.ladder.domain;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class DirectionTest {

    static Stream<Arguments> parseInitArguments() {
        return Stream.of(
                Arguments.of(true, false, Direction.LEFT),
                Arguments.of(false, false, Direction.BYPASS),
                Arguments.of(false, true, Direction.RIGHT)
        );
    }

    @ParameterizedTest(name = "init: {arguments}")
    @MethodSource("parseInitArguments")
    public void init(boolean left, boolean right, Direction expected) {
        assertThat(Direction.of(left, right)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true})
    public void init_invalid(boolean direction) {
        assertThatIllegalStateException().isThrownBy(() -> Direction.of(direction, direction));
    }

    static Stream<Arguments> parseNextArguments() {
        return Stream.of(
                Arguments.of(true, false, Direction.LEFT),
                Arguments.of(false, true, Direction.RIGHT)
                );
    }

    @ParameterizedTest(name = "next: {arguments}")
    @MethodSource("parseNextArguments")
    public void next(boolean first, boolean next, Direction expected) {
        assertThat(Direction.first(first).next(next)).isEqualTo(expected);
    }

    static Stream<Arguments> parseFirstArguments() {
        return Stream.of(
                Arguments.of(true, Direction.RIGHT),
                Arguments.of(false, Direction.BYPASS)
        );
    }

    @ParameterizedTest(name = "first: {arguments}")
    @MethodSource("parseFirstArguments")
    public void first(boolean first, Direction expected) {
        assertThat(Direction.first(first)).isEqualTo(expected);
    }

    static Stream<Arguments> parseLastArguments() {
        return Stream.of(
                Arguments.of(true, Direction.LEFT),
                Arguments.of(false, Direction.BYPASS)
        );
    }

    @ParameterizedTest(name = "last: {arguments}")
    @MethodSource("parseLastArguments")
    public void last(boolean first, Direction expected) {
        assertThat(Direction.first(first).last()).isEqualTo(expected);
    }

    static Stream<Arguments> parseDiffArguments() {
        return Stream.of(
                Arguments.of(true, false, -1),
                Arguments.of(false, false, 0),
                Arguments.of(false, true, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("parseDiffArguments")
    public void diff(boolean left, boolean right, int expected) {
        assertThat(Direction.of(left, right).diff()).isEqualTo(expected);

    }
}