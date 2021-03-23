package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void first() {
        assertThat(Point.first(TRUE).movableIndex()).isEqualTo(1);
        assertThat(Point.first(FALSE).movableIndex()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.movableIndex()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.movableIndex()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.movableIndex()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.movableIndex()).isEqualTo(0);
    }

    @Test
    public void last() {
        Point last = Point.first(FALSE).last();
        assertThat(last.movableIndex()).isEqualTo(1);
    }

}
