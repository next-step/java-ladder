package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

import static ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("포인트를 생성한다.")
    void Point_포인트_생성() {
        assertThat(new Point(0, STRAIGHT)).isNotNull().isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("포인트의 위치 값이 음수일 경우 예외가 발생한다.")
    void Point_위치값_음수() {
        assertThatThrownBy(() -> new Point(-1, STRAIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("포인트의 방향이 null 인 경우 예외가 발생한다.")
    void Point_방향이_null_인_경우(Direction direction) {
        assertThatThrownBy(() -> new Point(0, direction)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true, RIGHT",
            "false, STRAIGHT"
    })
    @DisplayName("첫번째 포인트의 위치와 방향을 정한다.")
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
    @DisplayName("이전 포인트의 방향을 참고하여 다음 포인트의 위치와 방향을 정한다.")
    void next_다음_포인트(int position, Direction currentDirection, boolean isRight, Direction nextDirection) {
        assertThat(new Point(position, currentDirection).next(isRight)).isEqualTo(new Point(position + 1, nextDirection));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3, LEFT, STRAIGHT",
            "3, STRAIGHT, STRAIGHT",
            "3, RIGHT, LEFT"
    })
    @DisplayName("이전 포인트의 방향을 참고하여 다음 포인트의 위치와 방향을 정한다.")
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
    @DisplayName("마지막 포인트인지 체크한다. (위치, 방향 모두 판별)")
    void isLast_마지막_포인트_체크(int position, Direction direction, int width, boolean isLast) {
        assertThat(new Point(position, direction).isLast(width)).isEqualTo(isLast);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, true",
            "1, 3, false"
    })
    @DisplayName("인접한 포인트의 차이가 1일 경우 true, 1 초과일 경우 false 를 반환한다.")
    void isPrevPoint_인접_포인트_차이(int previousPosition, int currentPosition, boolean trueOrFalse) {
        assertThat(new Point(previousPosition, STRAIGHT).isPreviousPoint(new Point(currentPosition, STRAIGHT))).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, true",
            "1, false"
    })
    @DisplayName("첫번째 포인트인지 체크한다. (위치만 체크)")
    void isFirstPosition_첫번째_위치(int position, boolean trueOrFalse) {
        assertThat(new Point(position, STRAIGHT).isFirstPosition()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2, 4, false",
            "3, 4, true"
    })
    @DisplayName("마지막 포인트인지 체크한다. (위치만 체크)")
    void isLastPosition_마지막_위치(int position, int width, boolean trueOrFalse) {
        assertThat(new Point(position, STRAIGHT).isLastPosition(width)).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, false",
            "LEFT, false",
            "RIGHT, true"
    })
    @DisplayName("포인트가 오른쪽 방향인지 체크한다.")
    void isRight_오른쪽_방향_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isRight()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, false",
            "LEFT, true",
            "RIGHT, false"
    })
    @DisplayName("포인트가 왼쪽 방향인지 체크한다.")
    void isLeft_왼쪽_방향_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isLeft()).isEqualTo(trueOrFalse);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "STRAIGHT, true",
            "LEFT, false",
            "RIGHT, false"
    })
    @DisplayName("포인트가 직진 방향인지 체크한다.")
    void isStraight_직진_방향_확인(Direction direction, boolean trueOrFalse) {
        assertThat(new Point(0, direction).isStraight()).isEqualTo(trueOrFalse);
    }

    @Test
    @DisplayName("첫번째 포인트가 왼쪽 방향일 경우 예외가 발생한다.")
    void validateFirstPoint_방향_예외() {
        Point firstPoint = new Point(0, LEFT);
        assertThatThrownBy(() -> firstPoint.validateFirstPoint()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫번째 포인트의 위치(position)이 0일 경우 예외가 발생한다.")
    void validateFirstPoint_위치_예외() {
        Point firstPoint = new Point(1, STRAIGHT);
        assertThatThrownBy(() -> firstPoint.validateFirstPoint()).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "LEFT, LEFT",
            "STRAIGHT, LEFT",
            "RIGHT, STRAIGHT",
            "RIGHT, RIGHT"
    })
    @DisplayName("중간 포인트의 방향과 이전 포인트의 방향이 엇갈릴 경우 예외가 발생한다.")
    void validateMiddlePoint_방향_예외(Direction previousPointDirection, Direction currentPointDirection) {
        Point previousPoint = new Point(1, previousPointDirection);
        Point currentPoint = new Point(2, currentPointDirection);
        assertThatThrownBy(() -> currentPoint.validateMiddlePoint(previousPoint)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중간 포인트와 이전 포인트의 위치(position)차이가 1이 아닌 경우 예외가 발생한다.")
    void validateMiddlePoint_위치_예외() {
        Point previousPoint = new Point(1, STRAIGHT);
        Point currentPoint = new Point(3, STRAIGHT);
        assertThatThrownBy(() -> currentPoint.validateMiddlePoint(previousPoint)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 포인트가 오른쪽 방향일 경우 예외가 발생한다.")
    void validateLastPoint_방향_예외() {
        int width = 4;
        Point lastPoint = new Point(width, RIGHT);
        assertThatThrownBy(() -> lastPoint.validateLastPoint(width)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 포인트가 '라인 폭 - 1' 값과 다를 경우 예외가 발생한다.")
    void validateLastPoint_위치_예외() {
        int width = 4;
        Point lastPoint = new Point(width - 2, RIGHT);
        assertThatThrownBy(() -> lastPoint.validateLastPoint(width)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("현재 포인트에서 오른쪽으로 이동한다.")
    void move_오른쪽_이동() {
        Point point = new Point(2, RIGHT);
        assertThat(point.move()).isEqualTo(3);
    }

    @Test
    @DisplayName("현재 포인트에서 왼쪽으로 이동한다.")
    void move_왼쪽_이동() {
        Point point = new Point(2, LEFT);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 포인트에서 직진한다.")
    void move_직진() {
        Point point = new Point(2, STRAIGHT);
        assertThat(point.move()).isEqualTo(2);
    }
}