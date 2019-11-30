package ladder.structure.connection.result;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.NoneMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    @DisplayName("point이동 경로 확인")
    void getPointsTest() {
        Points first = new Points(2, new DefaultMove());

        Points second = first.getNext(new DefaultMove());
        assertThat(second.getPoints())
                .containsExactly(Point.of(1), Point.of(0), Point.of(2));

        Points third = second.getNext(new DefaultMove());
        assertThat(third.getPoints())
                .containsExactly(Point.of(0), Point.of(1), Point.of(2));
    }

    @Test
    void constructorTest() {
        MoveStrategy none = new NoneMove();
        Points points = new Points(5, none);
        Points next = points.getNext(none);
        assertThat(next.getPoints()).isEqualTo(points.getPoints());

        MoveStrategy defaultMove = new DefaultMove();
        points = new Points(5, defaultMove);
        next = points.getNext(defaultMove);
        assertThat(next.getPoints())
                .containsExactly(Point.of(1), Point.of(0), Point.of(3), Point.of(2), Point.of(5), Point.of(4));
        assertThat(next.getNext(defaultMove).getPoints())
                .containsExactly(Point.of(0), Point.of(1), Point.of(2), Point.of(3), Point.of(4), Point.of(5));
    }
}