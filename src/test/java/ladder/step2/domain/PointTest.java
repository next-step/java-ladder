package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("패스")
    void pass() {
        Point point = new Point(false, false);
        assertThat(point.move()).isEqualTo(Direction.SOUTH);
    }
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        Point point = new Point(false, true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        Point point = new Point(true, false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }
}
