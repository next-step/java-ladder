package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(() -> false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(() -> false);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(() -> true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void last() {
        assertThat(Point.first(TRUE).last()).isEqualTo(new Point(1, Direction.of(true, false)));
    }

    @Test
    public void isLeft() {
        assertThat(Point.first(TRUE).isLeft()).isFalse();
    }
}
