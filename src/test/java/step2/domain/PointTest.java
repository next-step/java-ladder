package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫 번째 Point생성 테스트")
    void createFirstPointTest() {
        Point firstPoint = Point.first(0, new FixedGenerator(true));
        assertThat(firstPoint).isEqualTo(Point.first(0, new FixedGenerator(true)));
    }

    @Test
    void middle() {
    }

    @Test
    void last() {
    }

    @Test
    void move() {
    }

    @Test
    void hasLine() {
    }
}
