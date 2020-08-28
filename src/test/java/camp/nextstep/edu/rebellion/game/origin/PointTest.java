package camp.nextstep.edu.rebellion.game.origin;

import camp.nextstep.edu.rebellion.game.origin.Point;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isOne();
        assertThat(Point.first(FALSE).move()).isZero();
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isOne();
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isZero();
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isZero();
    }
}
