package ladder.structure.connection.result;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.NoneMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    @Test
    void constructorTest() {
        MoveStrategy defaultMove = new DefaultMove();
        Points points = new Points(4, defaultMove);
        assertThat(points.getPoints()).containsExactly(
                Point.of(false, defaultMove),
                Point.of(true, defaultMove),
                Point.of(false, defaultMove),
                Point.lastOf(true)
        );
    }

    @Test
    @DisplayName("point이동 경로 확인")
    void getPointsTest() {
        Points first = new Points(4, new DefaultMove());

        List<Integer> order = IntStream.range(0, 4).boxed().collect(Collectors.toList());
        order = first.moveNext(order);
        assertThat(order).containsExactly(1, 0, 3, 2);

        Points second = new Points(4, new NoneMove());
        order = second.moveNext(order);
        assertThat(order).containsExactly(1, 0, 3, 2);

        Points third = new Points(4, new DefaultMove());
        order = third.moveNext(order);
        assertThat(order).containsExactly(0, 1, 2, 3);
    }
}