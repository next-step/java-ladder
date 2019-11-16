package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PointTest {
    @Test
    void firstIndex() {
        assertThat(Point.firstIndex()).isIn(new Point(0, Direction.RIGHT), new Point(0, Direction.BOTTOM));
    }

    @Test
    void next() {
        Point point = new Point(0, Direction.RIGHT);
        assertThat(point.next(1)).isEqualTo(new Point(1, Direction.LEFT));

        point = new Point(0, Direction.LEFT);
        assertThat(point.next(1)).isEqualTo(new Point(1, Direction.BOTTOM));

        point = new Point(0, Direction.RIGHT);
        assertThat(point.next(3)).isEqualTo(new Point(1, Direction.LEFT));

        point = new Point(0, Direction.BOTTOM);
        assertThat(point.next(3)).isIn(new Point(1, Direction.BOTTOM), new Point(1, Direction.RIGHT));
    }
}
