package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void point_first_false_move_Test() {
        Point first = Point.first(false);
        assertThat(first.isMovableRight()).isFalse();
    }

    @Test
    void point_first_true_move_Test() {
        Point first = Point.first(true);
        assertThat(first.isMovableRight()).isTrue();
    }

    @Test
    void point_next_false_move_Test() {
        Point first = Point.first(false);
        Point next = first.next(false);
        assertThat(next.isMovableRight()).isFalse();
    }

    @Test
    void point_next_true_move_Test() {
        Point first = Point.first(false);
        Point next = first.next(true);
        assertThat(next.isMovableRight()).isTrue();
    }

    @Test
    void point_last_move_Test() {
        Point first = Point.first(false);
        Point next = first.next(false);
        Point last = next.last();
        assertThat(last.isMovableRight()).isFalse();
    }
}
