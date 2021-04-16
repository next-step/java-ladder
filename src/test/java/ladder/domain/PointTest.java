package ladder.domain;

import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void first() {
        assertThat(Point.first(TRUE).move()).isEqualTo(1);
        assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    public void next_stay() {
        // given
        Point point = Point.first(FALSE);

        // when
        Point second = point.next(() -> false);

        // then
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        // given
        Point point = Point.first(TRUE);

        // when
        Point second = point.next(() -> false);

        // then
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        // given
        Point point = Point.first(FALSE);

        // when
        Point second = point.next(() -> true);

        // then
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        // given
        Point point = Point.first(TRUE);

        // when
        Point second = point.next(() -> true);

        // then
        assertThat(second.move()).isEqualTo(0);
    }
}
