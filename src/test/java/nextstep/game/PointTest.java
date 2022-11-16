package nextstep.game;

import game.domain.ladder.Direction;
import game.domain.ladder.Point;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @Order(0)
    public void 시작점() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @Order(1)
    public void 끝점() {
        Point point = Point.last(2, true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @Order(2)
    public void 왼쪽_이동() {
        Point point = Point.next(1, Direction.of(true, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @Order(3)
    public void 직진() {
        Point point = Point.next(1, Direction.of(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @Order(4)
    public void 오른쪽_이동() {
        Point point = Point.next(1, Direction.of(false, true));
        assertThat(point.move()).isEqualTo(2);
    }
}
