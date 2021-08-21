package nextstep.ladders.domain;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class LadderTest {

    private static final PointGenerateStrategy strategy = (previous -> true);

    @ParameterizedTest
    @CsvSource(value = {"6:", "1:sff", "10:asd"}, delimiter = ':')
    void 사다리_높이가_숫자가_아니면_에러(final int countOfPerson, final String maxHeight) {
        assertThrows(NumberFormatException.class, () -> new Ladder(strategy, countOfPerson, maxHeight));
    }

    @ParameterizedTest
    @CsvSource(value = {"6:5", "1:2", "10:7"}, delimiter = ':')
    void 사다리_라인으로_생성(final int countOfPerson, final int height) {
        assertDoesNotThrow(() -> new Ladder(new Lines(strategy, countOfPerson, height)));
    }

    @ParameterizedTest
    @CsvSource(value = {"6:5", "1:2", "10:7"}, delimiter = ':')
    void 사다리_생성(final int countOfPerson, final int height) {
        assertDoesNotThrow(() -> new Ladder(strategy, countOfPerson, height));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    void 사다리_결과_확인(final int row, final int excepted) {

        Lines lines = getLines();
        Ladder ladder = new Ladder(lines);

        // when
        int result = ladder.start(row);

        //then
        assertEquals(excepted, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5"}, delimiter = ':')
    void 사다리_가로_길이_초과_에러(final int row) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(getLines());
            ladder.start(row);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1"}, delimiter = ':')
    void 사다리가_선이_이어져_있는경우_에러(final int row) {
        Lines lines = new Lines(List.of(new Line(List.of(false, true, true, false))));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Ladder ladder = new Ladder(lines);
            ladder.start(row);
        });
    }

    private Lines getLines() {
        /**
         *     |-----|     |-----|
         *     |     |-----|     |
         *     |-----|     |     |
         *     |     |-----|     |
         *     |-----|     |-----|
         */
        return new Lines(List.of(
                new Line(List.of(false, true, false, true)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(false, true, false, false)),
                new Line(List.of(false, false, true, false)),
                new Line(List.of(false, true, false, true))
        ));
    }
}