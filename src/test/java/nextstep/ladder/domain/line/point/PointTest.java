package nextstep.ladder.domain.line.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void create_성공() {
        Point point = new Point(true, false);

        assertThat(point).isNotNull();
        assertThat(point.canMoveLeft()).isTrue();
        assertThat(point.canMoveRight()).isFalse();
    }

    @Test
    @DisplayName("하나의 포인트에서 양쪽으로 동시에 이동할 수 없다")
    void create_실패() {
        assertThatThrownBy(() -> {
            Point point = new Point(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("첫 번째 포인트는 왼쪽으로 이동할 수 없고, 오른쪽으로만 이동 가능성이 있어야 한다")
    void first() {
        Point point = Point.first(true);

        assertThat(point.canMoveLeft()).isFalse();
    }

    @Test
    @DisplayName("마지막 포인트는 오른쪽으로 이동할 수 없고, 왼쪽으로만 이동 가능성이 있어야 한다")
    void last() {
        Point point = Point.first(true);
        Point lastPoint = point.last();

        assertThat(lastPoint.canMoveRight()).isFalse();
    }
}