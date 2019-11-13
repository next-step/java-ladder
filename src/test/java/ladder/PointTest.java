package ladder;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    void isFirstAndLast() {
        int people = 3;
        Point first = Point.first(TRUE);
        assertThat(first.isFirstAndLast(people)).isTrue();

        Point last = first.next(FALSE).last();
        assertThat(last.isFirstAndLast(people)).isTrue();
    }

    @Test
    void move_right() {
        Point right = Point.first(TRUE);
        assertThat(right.move()).isEqualTo(1);
    }

    @Test
    void move_left() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    void move_center() {
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    void create_first() {
        Point first = new Point(0, PointState.first(TRUE));
        assertThat(first).isEqualTo(Point.first(TRUE));
    }

    @Test
    void create_next() {
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second).isEqualTo(new Point(1, new PointState(TRUE, FALSE)));
    }
}
