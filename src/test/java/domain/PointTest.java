package domain;


import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
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
    public void next난이도상() {
        Difficult difficult = Difficult.valueOf("상");
        Point second = Point.first(TRUE).next(difficult);
        assertThat(second.move(), is(0));
    }
}