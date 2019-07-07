package ladder;


import ladder.domain.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void first() {
        Point first = Point.first(false);
        assertThat(first.move()).isEqualTo(0);
    }

    @Test
    public void next() {
        Point first = Point.first(false);
        Point next = first.next(false);
        assertThat(next.move()).isEqualTo(1);
    }

    @Test
    public void last() {
        Point first = Point.first(true);
        Point last = first.last();
        assertThat(last.move()).isEqualTo(0);
    }

    @Test
    public void move() {
        Point first = Point.first(false);
        assertThat(first.move()).isEqualTo(0);
    }
}
