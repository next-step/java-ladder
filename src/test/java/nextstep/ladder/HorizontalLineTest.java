package nextstep.ladder;

import nextstep.ladder.line.HorizontalLine;
import nextstep.ladder.point.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalLineTest {

    @Test
    void moveTest() {
        Point first = Point.first(true);
        Point second = first.next(false);
        Point third = second.next(false);

        List<Point> points = Arrays.asList(first, second, third);
        HorizontalLine horizontalLine = new HorizontalLine(points);

        assertThat(horizontalLine.move(0)).isEqualTo(1);
        assertThat(horizontalLine.move(1)).isEqualTo(0);
        assertThat(horizontalLine.move(2)).isEqualTo(2);
    }
}
