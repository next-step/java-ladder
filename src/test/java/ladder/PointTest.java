package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    @DisplayName("")
    void first() {
        assertThat(Point.first(false)).isEqualTo(Point.first(false));
        assertThat(Point.first(true)).isEqualTo(Point.first(true));
    }

    @ParameterizedTest
    @MethodSource("nextSource")
    @DisplayName("")
    void next(boolean left, boolean self, boolean nextSelf) {
        Point point = Point.first(left).next(self);
        Point nextPoint = point.next(nextSelf);

        assertThat(nextPoint).isEqualTo(Point.first(self).next(nextSelf));
    }

    static Stream<Arguments> nextSource () {
        return Stream.of(
                Arguments.of(false, false, false),
                Arguments.of(false, false, true),
                Arguments.of(false, true, false),
                Arguments.of(true, false, false),
                Arguments.of(true, false, true)
        );
    }

    @Test
    @DisplayName("")
    void invalid_next() {
        assertThatThrownBy(() -> Point.first(true).next(true)).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @MethodSource("moveSource")
    @DisplayName("")
    void move(boolean left, boolean self, Direction direction) {
        assertThat(Point.first(left).next(self).move()).isSameAs(direction);
    }

    static Stream<Arguments> moveSource () {
        return Stream.of(
                Arguments.of(false, false, PASS),
                Arguments.of(true, false, LEFT),
                Arguments.of(false, true, RIGHT)
        );
    }
}
