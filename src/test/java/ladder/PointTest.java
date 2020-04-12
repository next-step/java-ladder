package ladder;

import ladder.model.LadderPole;
import ladder.model.Point;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(LadderPole.of(1));
        assertThat(Point.first(FALSE).move()).isEqualTo(LadderPole.of(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(LadderPole.of(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(LadderPole.of(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(LadderPole.of(2));
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next();
        assertThat(second.move()).isEqualTo(LadderPole.of(0));
    }
}
