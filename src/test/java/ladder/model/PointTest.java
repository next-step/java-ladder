package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("첫 Point를 생성할 수 있다.")
    void firstOf_WithRightConnection_Created() {
        final Point point = Point.firstOf(before -> true);
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
        final Point first = Point.firstOf(before -> true);
        final Point next = first.nextOf(before -> false);
        assertThat(next).isInstanceOf(Point.class);
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
        final Point first = Point.firstOf(before -> true);
        final Point end = first.endOf();
        assertThat(end).isInstanceOf(Point.class);
    }

    @Test
    @DisplayName("Point의 오른쪽 연결 여부를 확인할 수 있다.")
    void isConnectedRight_isTrue() {
        Point point = Point.firstOf(before -> true);
        assertThat(point.isConnectedRight()).isTrue();

        point = Point.firstOf(before -> false);
        assertThat(point.isConnectedRight()).isFalse();
    }
}
