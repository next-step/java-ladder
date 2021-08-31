package nextstep.ladders;

import nextstep.ladders.exception.InvalidLineSizeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "0:1", "2:3", "3:2"}, delimiter = ':')
    void move_메서드_검증(final int index, final int actual) {
        Line line = new Line(points());
        int expected = line.move(index);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void 범위_초과(final int index) {
        Line line = new Line(points());
        assertThrows(InvalidLineSizeException.class, () -> line.move(index));
    }
}