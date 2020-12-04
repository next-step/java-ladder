package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void ofTest(){
        Point point = Point.of(Position.FIRST, Direction.RIGHT);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
        assertThat(point.getDirection() == Direction.RIGHT).isTrue();
    }

    @Test
    void nextTest() {
        Point point = Point.of(Position.FIRST, Direction.RIGHT);
        assertThat(point.next()).isEqualTo(1);
    }
}
