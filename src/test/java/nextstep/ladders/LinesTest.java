package nextstep.ladders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class LinesTest {

    public static List<Line> lines() {
        /**
         *     |-----|     |-----|
         *     |     |-----|     |
         * false true false true false
         * false false true false false
         */
        Line line1 = new Line(Arrays.asList(
                new Point(0, Direction.of(false, true)),
                new Point(1, Direction.of(true, false)),
                new Point(2, Direction.of(false, true)),
                new Point(3, Direction.of(true, false))
        ));
        Line line2 = new Line(Arrays.asList(
                new Point(0, Direction.of(false, false)),
                new Point(1, Direction.of(false, true)),
                new Point(2, Direction.of(true, false)),
                new Point(3, Direction.of(false, false))
        ));
        return Arrays.asList(line1, line2);
    }

    @Test
    void 정상_생성() {
        Lines expected = new Lines(lines());
        Lines actual = new Lines(lines());
        Assertions.assertEquals(expected, actual);
    }

}