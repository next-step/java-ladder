package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리에서 이동할 수 있는 포인트 테스트")
public class PointTest {
    @DisplayName("특정 위치의 포인트 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0", "1"})
    public void createPoint(int expectedPosition) {
        Point point = Point.of(Position.of(expectedPosition, 2), Direction.of(false, true));

        int position = point.getPosition();

        assertThat(position).isEqualTo(expectedPosition);
    }

    @DisplayName("미리 지정된 방향에 따라 포인트 이동")
    @ParameterizedTest
    @MethodSource("getMovingPoints")
    public void movePoint(Direction direction, int expectedPosition) {
        Point point = Point.of(Position.of(1, 2), direction);

        int position = point.move();

        assertThat(position).isEqualTo(expectedPosition);
    }

    static Stream<Arguments> getMovingPoints() {
        return Stream.of(Arguments.arguments(Direction.of(true, false), 0),
                Arguments.arguments(Direction.of(false, false), 1),
                Arguments.arguments(Direction.of(false, true), 2)
        );
    }

    @DisplayName("포인트가 왼쪽으로 이동 가능한지 확인")
    @ParameterizedTest
    @CsvSource(value = {"true", "false"})
    public void canMoveLeft(boolean expectedResult) {
        Point point = Point.of(Position.of(1, 2), Direction.of(expectedResult, false));

        boolean movableToLeft = point.hasLeft();

        assertThat(movableToLeft).isEqualTo(expectedResult);
    }

    @DisplayName("시작 포인트 포지")
    @Test
    public void firstPosition() {
        Point point = Point.first(10, false);

        int position = point.getPosition();

        assertThat(position).isEqualTo(0);
    }

    @DisplayName("시작 포인트 오른쪽 방향 유무")
    @Test
    public void firstRightDirection() {
        Point point = Point.first(10, false);

        boolean hasRight = point.hasRight();

        assertThat(hasRight).isEqualTo(false);
    }

    @DisplayName("시작 포인트 왼쪽 방향 유무")
    @Test
    public void firstLeftDirection() {
        Point point = Point.first(10, false);

        boolean hasLeft = point.hasLeft();

        assertThat(hasLeft).isEqualTo(false);
    }

    @DisplayName("다음 포인트 생서이 오른쪽 방향 확인")
    public void nextRightDirection() {
        Point point = Point.first(10, false).next(true);

        boolean hasRight = point.hasRight();

        assertThat(hasRight).isEqualTo(true);
    }

    @DisplayName("다음 포인트 생서이 왼쪽 방향 확인")
    public void nextLeftDirection() {
        Point point = Point.first(10, false).next(true);

        boolean hasLeft = point.hasLeft();

        assertThat(hasLeft).isEqualTo(true);
    }
}