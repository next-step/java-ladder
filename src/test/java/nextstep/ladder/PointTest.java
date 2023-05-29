package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    void firstTest() {
        Point point = Point.first(true);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void nextTest() {
        Point point = Point.first(true).next(true);
        assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
        Point point2 = Point.first(false).next(true);
        assertThat(point2.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void lastTest() {
        Point point = Point.first(true).next(true).last();
        assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
    }
}
