package nextstep.ladder;

import nextstep.ladder.domain.Point2;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class Point2Test {
    @Test
    public void first() {
        assertThat(Point2.first(TRUE).move(), is(1));
        assertThat(Point2.first(FALSE).move(), is(0));
    }

    @Test
    public void next_stay() {
        Point2 second = Point2.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @Test
    public void next_left() {
        Point2 second = Point2.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @Test
    public void next_right() {
        Point2 second = Point2.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @Test
    public void next() {
        Point2 second = Point2.first(TRUE).next();
        assertThat(second.move(), is(0));
    }
}
