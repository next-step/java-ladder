package nextstep.ladder.domain.direction;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void testCached() {
        Point point1 = Point.from(1, 2);
        Point point2 = Point.from(1, 2);

        assertThat(point1).isSameAs(point2);
    }

    @Test
    void moveRight() {
        Point point = Point.from(1, 2);

        assertThat(point.movePoint(Direction.RIGHT_DOWN)).isSameAs(Point.from(2, 3));
    }

    @Test
    void moveLeft() {
        Point point = Point.from(1, 2);

        assertThat(point.movePoint(Direction.LEFT_DOWN)).isSameAs(Point.from(0, 3));
    }

    @Test
    void moveDown() {
        Point point = Point.from(1, 2);

        assertThat(point.movePoint(Direction.DOWN)).isSameAs(Point.from(1, 3));
    }
}
