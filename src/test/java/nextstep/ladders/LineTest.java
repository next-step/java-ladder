package nextstep.ladders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class LineTest {

    public static List<Point> points() {
        /**
         * |-----|     |-----|
         * false true false true false
         */
        return Arrays.asList(
                new Point(0, Direction.of(false, true)),
                new Point(1, Direction.of(true, false)),
                new Point(2, Direction.of(false, true)),
                new Point(3, Direction.of(true, false))
        );
    }

    @Test
    void 정상_생성() {
        Line expected = new Line(points());
        Line actual = new Line(points());

        Assertions.assertEquals(expected, actual);
    }
}