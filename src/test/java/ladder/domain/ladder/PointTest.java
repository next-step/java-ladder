package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Point TEST")
class PointTest {

    @Test
    @DisplayName("첫번째 Point 초기화")
    void initFirst() {
        // given
        Point first = Point.first(() -> true);

        // when
        int nextPosition = first.move();

        // then
        assertThat(nextPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("다음 Point 초기화")
    void initNext() {
        // given
        Point point = Point.first(() -> false).next(() -> true);

        // when
        int nextPosition = point.move();

        // then
        assertThat(nextPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("마지막 Point 초기화")
    void initLast() {
        // given
        Point point = Point.first(() -> true).next(() -> false).last();

        // when
        int nextPosition = point.move();

        // then
        assertThat(nextPosition).isEqualTo(2);
    }

    static Stream<Arguments> provideFirstPoint() {
        return Stream.of(
                Arguments.of(true, Direction.RIGHT),
                Arguments.of(false, Direction.STRAIGHT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideFirstPoint")
    @DisplayName("첫번째 Point 비교 ")
    void rightDirectionWhenCompareFirstPoint(boolean moveAble, Direction direction) {
        // given
        Point point = Point.first(() -> moveAble);

        // when
        boolean actual = point.compareDirection(direction);

        // then
        assertThat(actual).isTrue();
    }

    static Stream<Arguments> provideNextPoint() {
        return Stream.of(
                Arguments.of(false, true, Direction.RIGHT),
                Arguments.of(false, false, Direction.STRAIGHT),
                Arguments.of(true, false, Direction.LEFT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNextPoint")
    @DisplayName("다음 Point 비교 ")
    void compareNextPoint(boolean firstMoveAble, boolean nextMoveAble, Direction direction) {
        // given
        Point point = Point.first(() -> firstMoveAble).next(() -> nextMoveAble);

        // when
        boolean actual = point.compareDirection(direction);

        // then
        assertThat(actual).isTrue();
    }

    static Stream<Arguments> provideLastPoint() {
        return Stream.of(
                Arguments.of(true, Direction.LEFT),
                Arguments.of(false, Direction.STRAIGHT)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLastPoint")
    @DisplayName("마지막 Point 비교 ")
    void compareNextPoint(boolean moveAble, Direction direction) {
        // given
        Point point = Point.first(() -> moveAble).last();

        // when
        boolean actual = point.compareDirection(direction);

        // then
        assertThat(actual).isTrue();
    }
}