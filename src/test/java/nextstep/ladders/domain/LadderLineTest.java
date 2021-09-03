package nextstep.ladders.domain;

import nextstep.ladders.exception.InvalidLineSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LadderLineTest {

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
    @DisplayName("생성 테스트")
    void create() {
        LadderLine expected = new LadderLine(points());
        LadderLine actual = new LadderLine(points());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "0:1", "2:3", "3:2"}, delimiter = ':')
    @DisplayName("move 메서드 검증")
    void moveMethodCheck(final int index, final int actual) {
        LadderLine ladderLine = new LadderLine(points());
        int expected = ladderLine.move(index);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    @DisplayName("범위 초과")
    void outOfRange(final int index) {
        LadderLine ladderLine = new LadderLine(points());
        assertThrows(InvalidLineSizeException.class, () -> ladderLine.move(index));
    }
}