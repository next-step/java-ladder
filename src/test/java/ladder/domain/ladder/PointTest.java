package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(new Position(1));
        assertThat(Point.first(FALSE).move()).isEqualTo(new Position(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(new Position(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(new Position(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(new Position(2));
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next(TRUE);
        assertThat(second.move()).isEqualTo(new Position(0));
    }
}
