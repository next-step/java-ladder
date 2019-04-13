package ladder.domain;

import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
    }

    @Test
    public void first_dont_move() {
        assertThat(Point.first(FALSE).move(), is(0));
    }

    @Test
    public void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @Test
    public void next_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @Test
    public void next_right() {
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @Test
    public void next() {
        Level level = Level.findLevel("middle");
        BooleanGenerator booleanGenerator = new BooleanGenerator(level);
        Point second = Point.first(TRUE).next(booleanGenerator);
        assertThat(second.move(), is(0));
    }

    @Test
    public void generatePointTest() {
        Point point1 = Point.of(0, Direction.of(false, false));
        Point point2 = Point.of(0, Direction.of(false, false));

    }
}
