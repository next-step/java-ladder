package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("Point 의 first method 에 인자로 true 를 주면 Direction 이 right 인 Point 를 반환")
    void first_right() {
        assertThat(Point.first(true)).isEqualTo(Point.of(Direction.of("right"), 0));
    }

    @Test
    @DisplayName("Point 의 first method 에 인자로 false 를 주면 Direction 이 none 인 Point 를 반환")
    void first_none() {
        assertThat(Point.first(false)).isEqualTo(Point.of(Direction.of("none"), 0));
    }

    @Test
    @DisplayName("Point 의 last method 에 인자로 Direction 이 left 인 Point 를 주면 Direction 이 none 인 Point 를 반환")
    void last_none() {
        Point lastPoint = Point.of(Direction.of("left"), 3).last(4);
        assertThat(lastPoint).isEqualTo(Point.of(Direction.of("none"), 4));
    }

    @Test
    @DisplayName("Point 의 last method 에 인자로 Direction 이 right 인 Point 를 주면 Direction 이 left 인 Point 를 반환")
    void last_left() {
        Point lastPoint = Point.of(Direction.of("right"), 3).last(4);
        assertThat(lastPoint).isEqualTo(Point.of(Direction.of("left"), 4));
    }

    @Test
    @DisplayName("Point 가 move 한 int 를 반환")
    void move() {
        Point pointA = Point.of(Direction.of("right"), 2);
        Point pointB = Point.of(Direction.of("none"), 10);
        Point pointC = Point.of(Direction.of("left"), 7);

        assertThat(pointA.move()).isEqualTo(3);
        assertThat(pointB.move()).isEqualTo(10);
        assertThat(pointC.move()).isEqualTo(6);
    }
}
