package nextstep.ladders.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {"6:", "1:sff", "10:asd"}, delimiter = ':')
    void 사다리_높이가_숫자가_아니면_에러(final int countOfPerson, final String maxHeight) {
        assertThrows(NumberFormatException.class, () -> new Ladder(countOfPerson, maxHeight));
    }

    @ParameterizedTest
    @CsvSource(value = {"6:5", "1:2", "10:7"}, delimiter = ':')
    void 사다리_라인으로_생성(final int countOfPerson, final int height) {
        assertDoesNotThrow(() -> new Ladder(new Lines(countOfPerson, height)));
    }

    @ParameterizedTest
    @CsvSource(value = {"6:5", "1:2", "10:7"}, delimiter = ':')
    void 사다리_생성(final int countOfPerson, final int height) {
        assertDoesNotThrow(() -> new Ladder(countOfPerson, height));
    }
}