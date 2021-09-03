package nextstep.ladders.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LadderLinesTest {

    public static List<LadderLine> lines() {
        /**
         *     |-----|     |-----|
         *     |     |-----|     |
         * false true false true false
         * false false true false false
         */
        LadderLine ladderLine1 = new LadderLine(Arrays.asList(
                new Point(0, Direction.of(false, true)),
                new Point(1, Direction.of(true, false)),
                new Point(2, Direction.of(false, true)),
                new Point(3, Direction.of(true, false))
        ));
        LadderLine ladderLine2 = new LadderLine(Arrays.asList(
                new Point(0, Direction.of(false, false)),
                new Point(1, Direction.of(false, true)),
                new Point(2, Direction.of(true, false)),
                new Point(3, Direction.of(false, false))
        ));
        return Arrays.asList(ladderLine1, ladderLine2);
    }

    @Test
    @DisplayName("생성 테스트")
    void create() {
        LadderLines expected = new LadderLines(lines());
        LadderLines actual = new LadderLines(lines());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:0", "2:3", "3:1"}, delimiter = ':')
    @DisplayName("move 메서드 검증")
    void moveMethodCheck(final int start, final int actual) {
        LadderLines ladderLines = new LadderLines(lines());
        assertEquals(ladderLines.move(start), actual);
    }

}