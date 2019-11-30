package ladder.structure.connection.result;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void setDirectionTest() {
        MoveStrategy defaultMove = new DefaultMove();
        Point before = null;
        Point now = Point.of(0).setDirection(before, defaultMove);
        assertThat(now.getDirection()).isEqualTo(Direction.RIGHT);

        before = now;
        now = Point.of(1).setDirection(before, defaultMove);
        assertThat(now.getDirection()).isEqualTo(Direction.LEFT);

        before = now;
        now = Point.of(2).setDirection(before, defaultMove);
        now.setDirectionOfLast();
        assertThat(now.getDirection()).isEqualTo(Direction.STAY);
    }
}


