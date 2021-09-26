package nextstep.ladder.model.v2;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    public void last() {
        assertThat(Point.first(TRUE).last().move()).isEqualTo(0);
        assertThat(Point.first(FALSE).last().move()).isEqualTo(1);
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(TRUE).next(new RandomLadderPointGenerator());
        assertThat(second.move()).isEqualTo(0);
    }
}