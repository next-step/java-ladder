package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.first(true).next(true));
    }

    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

     @Test
     void south() {
         Point point = Point.first(false).next(false);
         assertThat(point.move()).isEqualTo(Direction.SOUTH);
     }
}
