package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void creation_test() {
        Point point = Point.of(1, Direction.of(false, false));
        assertThat(point).isEqualTo(Point.of(1, Direction.of(false, false)));
    }

    @Test
    void lastPoint_test() {
        Point point = Point.of(3, Direction.of(false, true));
        assertThat(point.last()).isEqualTo(Point.of(4, Direction.of(true, false)));
    }

    @Test
    void next_test() {
        Point point = Point.of(0, Direction.of(false, true));
        assertThat(point.next()).isEqualTo(Point.of(1, Direction.of(true, false)));
    }

    @Test
    void right_move_test() {
        Point point = Point.of(0, Direction.of(false, true));
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    void left_move_test() {
        Point point = Point.of(3, Direction.of(true, false));
        assertThat(point.move()).isEqualTo(2);
    }

    @Test
    void stay_test() {
        Point point = Point.of(3, Direction.of(false, false));
        assertThat(point.move()).isEqualTo(3);
    }
}
