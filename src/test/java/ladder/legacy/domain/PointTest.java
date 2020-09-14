package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void point_creation_test() {
        Point firstPoint = Point.ofFirstPoint(true);
        assertThat(firstPoint.getLeft()).isFalse();

        Point lastPoint = Point.ofLastPoint(false);
        assertThat(lastPoint.getRight()).isFalse();
    }

    @Test
    void create_next_point_test() {
        Point point = Point.of(Direction.of(false, true));
        Point nextPoint = point.getNext();

        assertThat(point.getRight()).isEqualTo(nextPoint.getLeft());
    }

    @Test
    void Point_move_test() {

        Point firstPoint = Point.ofFirstPoint(true);
        assertThat(firstPoint.move()).isEqualTo(1);

        Point lastPoint = Point.ofLastPoint(true);
        assertThat(lastPoint.move()).isEqualTo(-1);

        Point point = Point.of(Direction.of(false, false));
        assertThat(point.move()).isEqualTo(0);
    }
}
