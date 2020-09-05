package ladder.domain;

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

}
