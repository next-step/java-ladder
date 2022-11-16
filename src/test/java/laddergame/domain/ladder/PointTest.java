package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class PointTest {
    public static Stream<Arguments> provideDirectionAndMovedIndex() {
        return Stream.of(
                Arguments.of(new Direction(true, false), 0),
                Arguments.of(new Direction(false, true), 2),
                Arguments.of(new Direction(false, false), 1)
        );
    }

    @Test
    void 생성() {
        assertThatNoException().isThrownBy(() -> new Point(0, Direction.first(true)));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 첫번째_생성(boolean right) {
        Point point = Point.first(right);
        compareIndexAndDirection(point, 0, new Direction(false, right));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 마지막_생성(boolean right) {
        Point point = new Point(2, false, right).last();
        compareIndexAndDirection(point, 3, new Direction(right, false));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 다음_생성_True(boolean next) {
        Point point = new Point(2, false, false).next(next);
        compareIndexAndDirection(point, 3, new Direction(false, next));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 다음_생성_False(boolean next) {
        Point point = new Point(2, false, true).next(next);
        compareIndexAndDirection(point, 3, new Direction(true, false));
    }

    private void compareIndexAndDirection(Point point, int index, Direction direction) {
        assertThat(point.getIndex()).isEqualTo(index);
        assertThat(point.getDirection()).isEqualTo(direction);
    }

    @ParameterizedTest
    @MethodSource("provideDirectionAndMovedIndex")
    void 이동(Direction direction, int expected) {
        Point point = new Point(1, direction);
        assertThat(point.move()).isEqualTo(expected);
    }
}
