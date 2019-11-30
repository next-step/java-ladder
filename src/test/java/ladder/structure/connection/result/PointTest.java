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
        Point rightOpenedPoint = Point.of(false, defaultMove);
        assertThat(rightOpenedPoint.diffOfNextIndex()).isEqualTo(RIGHT.getNum());

        Point leftOpenedPoint = Point.of(true, defaultMove);
        assertThat(leftOpenedPoint.diffOfNextIndex()).isEqualTo(LEFT.getNum());

        Point lastAndRightOpenedPoint = Point.lastOf(false);
        assertThat(lastAndRightOpenedPoint.diffOfNextIndex()).isEqualTo(STAY.getNum());
    }
}


