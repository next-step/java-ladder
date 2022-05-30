package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void move() {
        Point point1 = Point.first(true);
        Point point2 = Point.first(false);
        Moving moving1 = new Moving(0, point1);
        Moving moving2 = new Moving(1, point1.next(false));
        Moving moving3 = new Moving(2, point1.first(false).next(true));
        Moving moving4 = new Moving(3, point1.last());

        Moving movingA = new Moving(0, point2);
        Moving movingB = new Moving(1, point2.next(true));
        Moving movingC = new Moving(2, point2.first(true).next(false));
        Moving movingD = new Moving(3, point2.last());

        Line line1 = new Line(Arrays.asList(moving1, moving2, moving3, moving4));
        Line line2 = new Line(Arrays.asList(movingA, movingB, movingC, movingD));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2));
        Assertions.assertThat(ladder.resultIndexes()).isEqualTo(Arrays.asList(2, 0, 3, 1));
    }
}
