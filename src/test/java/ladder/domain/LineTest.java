package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(List<Boolean> input) {
        assertThat(new Line(input)).isEqualTo(new Line(input));
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, false, false)),
                Arguments.of(Arrays.asList(false, true, false)),
                Arguments.of(Arrays.asList(false, false, false, true))
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_createSource")
    void invalid_create(List<Boolean> input) {
        assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(true, false, false)),
                Arguments.of(Arrays.asList(true, false, true)),
                Arguments.of(Arrays.asList(false, true, true)),
                Arguments.of(Arrays.asList(true, false, false, false)),
                Arguments.of(Arrays.asList(true, false, true, false)),
                Arguments.of(Arrays.asList(true, false, false, true)),
                Arguments.of(Arrays.asList(false, true, true, false)),
                Arguments.of(Arrays.asList(false, false, true, true))
        );
    }

    @ParameterizedTest
    @MethodSource("nextPositionSource")
    @DisplayName("Line 은 사용자의 위치를 받아 다음 위치를 반환할 수 있다.")
    void nextPosition(List<Boolean> input, int currPos, int result) {
        // given
        Line line = new Line(input);

        // when
        final Position nextPos = line.nextPosition(new Position(currPos));

        // then
        assertThat(nextPos).isEqualTo(new Position(result));
    }

    static Stream<Arguments> nextPositionSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, false), 0, 0),
                Arguments.of(Arrays.asList(false, true), 0, 1),
                Arguments.of(Arrays.asList(false, true), 1, 0),
                Arguments.of(Arrays.asList(false, false, false), 1, 1),
                Arguments.of(Arrays.asList(false, true, false), 1, 0),
                Arguments.of(Arrays.asList(false, false, true), 1, 2)
        );
    }
}
