package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @DisplayName("우측으로 이동")
    @Test
    public void moveToRight() {
        Point point = Point.first(true);
        assertThat(point.nextDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("좌측으로 이동")
    @Test
    public void moveToLeft() {
        Point point = Point.last(true);
        assertThat(point.nextDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("밑으로 이동")
    @Test
    public void moveToDown() {
        Point point = Point.first(false);
        assertThat(point.nextDirection()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("연속된 선은 존재할 수 없다.")
    @Test
    public void invalidLine() {
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
