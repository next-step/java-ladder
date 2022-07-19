package ladder.domain.second;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("오른쪽에 라인이 있는 경우 오른쪽으로 위치 이동")
    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽에 라인이 있는 경우 왼쪽으로 위치 이동")
    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }


    @DisplayName("양쪽에 라인이 없는 경우 아래쪽으로 위치 이동")
    @Test
    void pass() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @DisplayName("양쪽에 라인이 있는 경우 예외 발생")
    @Test
    void invalid() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양쪽에 사다리 선이 생성될 수 없습니다.");
    }

    @DisplayName("첫번째 위치 생성하고, 오른쪽에 라인이 있는경우 오른쪽 이동")
    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("마지막 위치 생성하고, 왼쪽에 라인이 있는경우 왼쪽 이동")
    @Test
    void last() {
        Point point = Point.first(true).last();
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }
}
