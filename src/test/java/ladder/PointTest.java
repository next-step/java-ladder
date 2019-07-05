package ladder;


import ladder.domain.Point;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {

    @Test
    public void create_first_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Point(0,true, true);
        });
    }

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
    public void next_invalid() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()-> {
            Point.first(true).next(true);
        });
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
