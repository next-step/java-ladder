package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("첫 Point를 생성할 수 있다.")
    void firstOf_WithRightConnection_Created() {
        final Point point = Point.firstOf(c -> Direction.RIGHT);
        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("첫 Point를 Random으로 생성할 수 있다.")
    void firstOfRandom_Created() {
        final Point point = Point.firstOf(new RandomConnector());
        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("다음 Point를 생성할 수 있다.")
    void nextOf_WithCurrentPositionAndRightConnection_Created() {
        final Point first = Point.firstOf(c -> Direction.RIGHT);
        final Point next = first.nextOf(c -> Direction.LEFT);
        assertThat(next).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("이전 Point와 생성될 다음 Point에서 연속으로 연결되어 있으면 예외가 발생한다.")
    void nextOf_WithTwoWayConnection_ExceptionThrown() {
        final Point first = Point.firstOf(c -> Direction.RIGHT);
        assertThatThrownBy(() -> first.nextOf(c -> Direction.RIGHT))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다음 Point를 랜덤으로 생성할 수 있다.")
    void nextOfRandom_Created() {
        final Point first = Point.firstOf(new RandomConnector());
        final Point next = first.nextOf(new RandomConnector());
        assertThat(next).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("마지막 Point를 생성할 수 있다.")
    void endOf_WithCurrentPosition_Created() {
        final Point first = Point.firstOf(c -> Direction.RIGHT);
        final Point end = first.endOf();
        assertThat(end).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("Point의 오른쪽 연결 여부를 확인할 수 있다.")
    void isConnectedRight_isTrue() {
        Point point = Point.firstOf(c -> Direction.RIGHT);
        assertThat(point.isConnectedRight()).isTrue();

        point = Point.firstOf(c -> Direction.DOWN);
        assertThat(point.isConnectedRight()).isFalse();
    }

    @Test
    @DisplayName("Point의 오른쪽 이동")
    void move_RightConnection_Moved() {
        final Point point = Point.firstOf(c -> Direction.RIGHT);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("Point의 제자리 이동")
    void move_NotConnection_Moved() {
        final Point point = Point.firstOf(c -> Direction.DOWN);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("Point의 왼쪽 이동")
    void move_LeftConnection_Moved() {
        final Point first = Point.firstOf(c -> Direction.RIGHT);
        final Point point = first.nextOf(c -> Direction.LEFT);
        assertThat(point.move()).isEqualTo(0);
    }
}
