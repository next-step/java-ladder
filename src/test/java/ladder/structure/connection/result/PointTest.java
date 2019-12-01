package ladder.structure.connection.result;

import ladder.structure.connection.DefaultMove;
import ladder.structure.connection.MoveStrategy;
import ladder.structure.connection.NoneMove;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void constructorTest() {
        MoveStrategy defaultMove = new DefaultMove();
        MoveStrategy noneMove = new NoneMove();

        assertThat(Point.of(false, defaultMove))
                .isEqualTo(Point.of(false, defaultMove));
        assertThat(Point.lastOf(true))
                .isEqualTo(Point.of(true, defaultMove));
        assertThat(Point.lastOf(false))
                .isEqualTo(Point.of(false, noneMove));
    }

    @Test
    void moveNext() {
        final List<Point> points = new ArrayList<>();

        MoveStrategy noneMove = new NoneMove();
        for (int i = 0; i <= 7; i++) {
            points.add(Point.of(false, noneMove));
        }

        List<Integer> now = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        now = now.stream()
                .map(num -> points.get(num).getNextIndex(num))
                .collect(Collectors.toList());
        assertThat(now).containsExactly(0, 1, 2, 3, 4, 5, 6, 7);

        final List<Point> points2 = new ArrayList<>();
        MoveStrategy defaultMove = new DefaultMove();

        points2.add(Point.of(false, noneMove));
        for (int i = 0; i < 3; i++) {
            points2.add(Point.of(false, defaultMove));
            points2.add(Point.of(true, defaultMove));
        }
        points2.add(Point.lastOf(false));

        now = now.stream()
                .map(num -> points2.get(num).getNextIndex(num))
                .collect(Collectors.toList());
        assertThat(now).containsExactly(0, 2, 1, 4, 3, 6, 5, 7);
    }
}


