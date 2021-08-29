package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("Line 생성 에러 테스트 - right, none, none")
    public void createLine1() {
        // given
        Point point0 = new Point(0, Direction.RIGHT);
        Point point1 = new Point(1, Direction.NONE);
        Point point2 = new Point(2, Direction.NONE);
        List<Point> points = Arrays.asList(point0, point1, point2);
        String message = "사다리 지점의 바 생성 방향이 부적절합니다";

        // when
        ThrowingCallable throwingCallable = () -> new Line(points);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("Line 생성 테스트 - right, left, left")
    public void createLine2() {
        // given
        Point point0 = new Point(0, Direction.RIGHT);
        Point point1 = new Point(1, Direction.LEFT);
        Point point2 = new Point(2, Direction.LEFT);
        List<Point> points = Arrays.asList(point0, point1, point2);
        String message = "사다리 지점의 바 생성 방향이 부적절합니다";

        // when
        ThrowingCallable throwingCallable = () -> new Line(points);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("Line 생성 - playerCount 값이 0보다 작은 경우")
    public void lessThanZeroPlayerCount() {
        // given
        int playerCount = -1;
        String message = String.format("playerCount 값은 0보다 작을 수 없습니다 -> %d", playerCount);

        // when
        ThrowingCallable throwingCallable = () -> new Line(playerCount);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("getBarInstalledStatus 테스트")
    public void getBarInstalledStatus() {
        // given
        Line line = new Line(4);
        int expected = 3;

        // when
        List<Boolean> barInstalledStatus = line.getLineBarStatus();
        int size = barInstalledStatus.size();

        // then
        assertThat(size).isEqualTo(expected);
        assertThat(isContinuesBarInstalled(barInstalledStatus)).isEqualTo(false);
    }

    private boolean isContinuesBarInstalled(final List<Boolean> barInstalledStatus) {
        AtomicBoolean prevBar = new AtomicBoolean(false);
        return barInstalledStatus.stream()
                .anyMatch(barInstalled -> prevBar.getAndSet(barInstalled) && barInstalled);
    }

    @Test
    @DisplayName("moveFrom 테스트 - 범위를 벗어나는 경우")
    public void moveFromOverPosition() {
        // given
        Point point0 = new Point(0, Direction.RIGHT);
        Point point1 = new Point(1, Direction.LEFT);
        Point point2 = new Point(2, Direction.NONE);
        List<Point> points = Arrays.asList(point0, point1, point2);
        Line line = new Line(points);
        int position = 3;
        String message = String.format("해당 position 에는 Point 가 존재하지 않습니다 -> %d", position);

        // when
        ThrowingCallable throwingCallable = () -> line.moveFrom(position);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("moveFrom 테스트")
    public void moveFrom() {
        // given
        Point point0 = new Point(0, Direction.RIGHT);
        Point point1 = new Point(1, Direction.LEFT);
        Point point2 = new Point(2, Direction.NONE);
        List<Point> points = Arrays.asList(point0, point1, point2);
        Line line = new Line(points);
        int expectedPoint0 = 1;
        int expectedPoint1 = 0;
        int expectedPoint2 = 2;

        // when
        int point0Moved = line.moveFrom(0);
        int point1Moved = line.moveFrom(1);
        int point2Moved = line.moveFrom(2);

        // then
        assertThat(point0Moved).isEqualTo(expectedPoint0);
        assertThat(point1Moved).isEqualTo(expectedPoint1);
        assertThat(point2Moved).isEqualTo(expectedPoint2);
    }
}