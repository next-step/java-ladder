package nextstep.ladders.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:3", "3:1"}, delimiter = ':')
    void move_메서드_검증(final int start, final int actual) {
        Lines lines = new Lines(lines());
        assertEquals(lines.move(start), actual);
    }

}