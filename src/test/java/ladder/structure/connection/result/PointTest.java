package ladder.structure.connection.result;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import org.junit.jupiter.api.Test;

import static ladder.structure.connection.result.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void constructorTest() {
        MoveStrategy defaultMove = new DefaultMove();
        Point pointOpenToRight = Point.of(false, defaultMove);
        assertThat(pointOpenToRight.getDirection()).isEqualTo(RIGHT);

        Point pointCloseToRight = Point.of(true, defaultMove);
        assertThat(pointCloseToRight.getDirection()).isEqualTo(LEFT);

        Point lastAndOpenToRight = Point.lastOf(false);
        assertThat(lastAndOpenToRight.getDirection()).isEqualTo(STAY);
    }
}


