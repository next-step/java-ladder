package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("첫 Point를 생성할 수 있다.")
    void firstOf_WithRightConnection_Created() {
        final Point point = Point.firstOf(true);
        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("첫 Point를 Random으로 생성할 수 있다.")
    void firstOfRandom_Created() {
        final Point point = Point.firstOfRandom();
        assertThat(point).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("다음 Point를 생성할 수 있다.")
    void nextOf_WithCurrentPositionAndRightConnection_Created() {
        final Point first = Point.firstOf(true);
        final Point next = first.nextOf(false);
        assertThat(next).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("이전 Point와 생성될 다음 Point에서 연속으로 연결되어 있으면 예외가 발생한다.")
    void nextOf_WithTwoWayConnection_ExceptionThrown() {
        final Point first = Point.firstOf(true);
        assertThatThrownBy(() -> first.nextOf(true))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다음 Point를 랜덤으로 생성할 수 있다.")
    void nextOfRandom_Created() {
        final Point first = Point.firstOfRandom();
        final Point next = first.nextOfRandom();
        assertThat(next).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("마지막 Point를 생성할 수 있다.")
    void endOf_WithCurrentPosition_Created() {
        final Point first = Point.firstOf(true);
        final Point end = first.endOf();
        assertThat(end).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("Point의 오른쪽 연결 여부를 확인할 수 있다.")
    void isConnectedRight_isTrue() {
        Point point = Point.firstOf(true);
        assertThat(point.isConnectedRight()).isTrue();

        point = Point.firstOf(false);
        assertThat(point.isConnectedRight()).isFalse();
    }
}
