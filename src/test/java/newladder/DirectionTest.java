package newladder;


import newladder.model.Direction;
import newladder.model.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void 오른쪽방향_다음위치값() {
        Point point = new Point(false, true);
        Direction direction = new Direction(point);
        assertThat(direction.move()).isEqualTo(1);
    }

    @Test
    void 왼쪽방향_다음위치값() {
        Point point = new Point(true, false);
        Direction direction = new Direction(point);
        assertThat(direction.move()).isEqualTo(-1);
    }

    @Test
    void 멈춤_다음위치값() {
        Point point = new Point(false, false);
        Direction direction = new Direction(point);
        assertThat(direction.move()).isEqualTo(0);
    }
}
