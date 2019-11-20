package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void 생성() {
        Point point = Point.ofFirst(true);
        assertThat(point).isEqualTo(Point.ofFirst(true));
    }

    @Test
    public void move_left() {
        Point point = Point.ofFirst(true).createNext(false);
        assertThat(point.move()).isEqualTo(1 - 1);
    }

    @Test
    public void move_right() {
        Point pointA = Point.ofFirst(false).createNext(true);
        assertThat(pointA.move()).isEqualTo(1 + 1);
    }

    @Test
    public void move_straight() {
        Point pointA = Point.ofFirst(false).createNext(false);
        assertThat(pointA.move()).isEqualTo(1 + 0);
    }
}
