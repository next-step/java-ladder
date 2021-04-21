package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.LEFT 인지 확인")
    @Test
    void left() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.RIGHT 인지 확인")
    @Test
    void right() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.PASS 인지 확인")
    @Test
    void pass() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }
}