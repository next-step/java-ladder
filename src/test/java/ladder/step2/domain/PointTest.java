package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("패스")
    void pass() {
        Point point = new Point(PositionTest.ONE, DirectionTest.PASS);
        assertThat(point.move()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        Point point = new Point(PositionTest.ONE, DirectionTest.LEFT);
        assertThat(point.move()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        Point point = new Point(PositionTest.ONE, DirectionTest.RIGHT);
        assertThat(point.move()).isEqualTo(2);
    }
    
    @Nested
    @DisplayName("처음 부분라인은 존재하지 않는다")
    class CreateFirst {
        @RepeatedTest(100)
        void create_first() {
            Point first = Point.createFirst();
            assertThat(first.move()).isNotEqualTo(-1);
        }
    }
}
