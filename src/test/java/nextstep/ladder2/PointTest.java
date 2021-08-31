package nextstep.ladder2;

import nextstep.ladder2.domain.Direction;
import nextstep.ladder2.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("point 이동 없음")
    void pointNotMove() {
        assertThat(Point.first(false).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("point 오른쪽 이동")
    void pointRightMove() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("point 왼쪽 이동")
    void pointLeftMove() {
        Point point = new Point(new Direction(true, false), 1);
        assertThat(point.move()).isEqualTo(0);
    }
}
