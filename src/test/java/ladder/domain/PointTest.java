package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void Point_포인트_생성() {
        assertThat(new Point(0, Direction.STRAIGHT)).isNotNull().isInstanceOf(Point.class);
    }

    @Test
    void Point_위치값이_음수인_경우() {
        assertThatThrownBy(() -> new Point(-1, Direction.STRAIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void Point_방향이_null_인_경우(Direction direction) {
        assertThatThrownBy(() -> new Point(0, direction)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true, RIGHT",
            "false, STRAIGHT"
    })
    void first_첫번쨰_포인트(boolean isRight, Direction direction) {
        assertThat(Point.first(isRight)).isEqualTo(new Point(0, direction));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1, LEFT, true, RIGHT",
        "1, LEFT, false, STRAIGHT",
        "1, STRAIGHT, true, RIGHT",
        "1, STRAIGHT, false, STRAIGHT",
        "1, RIGHT, true, LEFT",
        "1, RIGHT, false, LEFT"
    })
    void next_다음_포인트(int position, Direction currentDirection, boolean isRight, Direction nextDirection) {
        assertThat(new Point(position, currentDirection).next(isRight)).isEqualTo(new Point(position + 1, nextDirection));
    }

    @ParameterizedTest
    @CsvSource(value = {
        "3, LEFT, STRAIGHT",
        "3, STRAIGHT, STRAIGHT",
        "3, RIGHT, LEFT"
    })
    void last_마지막_포인트(int position, Direction currentDirection, Direction lastDirection) {
        assertThat(new Point(position, currentDirection).last()).isEqualTo(new Point(position + 1, lastDirection));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "4, RIGHT, 4, false",
            "4, RIGHT, 3, false",
            "4, RIGHT, 5, false",
            "4, LEFT, 4, true",
            "4, LEFT, 3, false",
            "4, LEFT, 5, false",
            "4, STRAIGHT, 4, true",
            "4, STRAIGHT, 3, false",
            "4, STRAIGHT, 5, false"
    })
    void isLast_마지막_포인트_방향_체크(int position, Direction direction, int width, boolean isLast) {
        assertThat(new Point(position, direction).isLast(width)).isEqualTo(isLast);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, true",
            "1, 3, false"
    })
    void isPrevPoint_인접한_포인트_차이(int previousPosition, int currentPosition, boolean trueOrFalse) {
        assertThat(new Point(previousPosition, Direction.STRAIGHT).isPreviousPoint(new Point(currentPosition, Direction.STRAIGHT))).isEqualTo(trueOrFalse);
    }


    @ParameterizedTest
    @CsvSource(value = {
        "0, true",
        "1, false"
    })
    void isFirstPosition_첫번째_위치(int position, boolean trueOrFalse) {
        assertThat(new Point(position, Direction.STRAIGHT).isFirstPosition()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 3, false",
            "3, 3, true"
    })
    void isLastPosition_마지막_위치(int position, int width, boolean trueOrFalse) {
        assertThat(new Point(position, Direction.STRAIGHT).isLastPosition(width)).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, false",
            "LEFT, false",
            "RIGHT, true"
    })
    void isRight_오른쪽_방향_인지_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isRight()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, false",
            "LEFT, true",
            "RIGHT, false"
    })
    void isRight_왼쪽_방향_인지_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isLeft()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, true",
            "LEFT, false",
            "RIGHT, false"
    })
    void isRight_직진_방향_인지_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isStraight()).isEqualTo(trueOrFalse);
    }
}