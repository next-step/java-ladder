package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PointTest {
    public static final Point LEFT_MOVABLE_POINT = Point.createPoint(true, false);
    public static final Point RIGHT_MOVABLE_POINT = Point.createPoint(false, true);
    public static final Point NOT_MOVE = Point.createPoint(false, false);

    @Test
    public void 왼쪽_이동_가능() {
        assertThat(LEFT_MOVABLE_POINT.isLeftMovable()).isTrue();
    }

    @Test
    public void 왼쪽_이동_불가() {
        assertThat(RIGHT_MOVABLE_POINT.isLeftMovable()).isFalse();
        assertThat(NOT_MOVE.isLeftMovable()).isFalse();
    }

    @Test
    public void 오른쪽_이동_가능() {
        assertThat(RIGHT_MOVABLE_POINT.isRightMovable()).isTrue();
    }

    @Test
    public void 오른쪽_이동_불가() {
        assertThat(LEFT_MOVABLE_POINT.isRightMovable()).isFalse();
        assertThat(NOT_MOVE.isRightMovable()).isFalse();
    }

    @Test
    public void 오른쪽_이동() {
        assertThat(RIGHT_MOVABLE_POINT.movePoint()).isEqualTo(1);
    }

    @Test
    public void 왼쪽_이동() {
        assertThat(LEFT_MOVABLE_POINT.movePoint()).isEqualTo(-1);
    }

    @Test
    public void 이동_없음() {
        assertThat(NOT_MOVE.movePoint()).isEqualTo(0);
    }
}
