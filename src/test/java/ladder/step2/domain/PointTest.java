package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {
    public static final Point ONE_RIGHT = new Point(PositionTest.ONE, DirectionTest.RIGHT);
    public static final Point ONE_LEFT = new Point(PositionTest.ONE, DirectionTest.LEFT);
    public static final Point ONE_PASS = new Point(PositionTest.ONE, DirectionTest.PASS);
    
    @Test
    @DisplayName("패스")
    void pass() {
        assertThat(ONE_PASS.move()).isEqualTo(1);
    }
    
    @Test
    @DisplayName("왼쪽 이동")
    void move_left() {
        assertThat(ONE_LEFT.move()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("오른쪽 이동")
    void move_right() {
        assertThat(ONE_RIGHT.move()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("처음 부분라인은 존재하지 않는다")
    void create_first() {
        assertThat(Point.createFirst().move()).isNotEqualTo(-1);
    }
    
    @Test
    @DisplayName("마지막 부분라인은 존재하지 않는다")
    void create_last() {
        final Point twoLeft = ONE_RIGHT.createLast();
        assertAll(
                () -> assertThat(twoLeft.move()).isNotEqualTo(3),
                () -> assertThat(twoLeft.move()).isNotEqualTo(2),
                () -> assertThat(twoLeft.move()).isEqualTo(1)
        );
    }
    
    @Test
    @DisplayName("이전 부분 라인과 겹치지 않는다.")
    void create_next() {
        final Point twoLeft = ONE_RIGHT.createNext();
        assertAll(
                () -> assertThat(twoLeft.move()).isNotEqualTo(3),
                () -> assertThat(twoLeft.move()).isNotEqualTo(2),
                () -> assertThat(twoLeft.move()).isEqualTo(1)
        );
    }
}
