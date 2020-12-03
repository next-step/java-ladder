package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void ofTest(){
        Point point = Point.of(0, Direction.RIGHT);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
        assertThat(point.getDirection() == Direction.RIGHT).isTrue();
    }
}
