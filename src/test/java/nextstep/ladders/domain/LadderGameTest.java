package nextstep.ladders.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = "pobi,honux,crong,jk:5", delimiter = ':')
    void create(final String participantsText, final String maxLadderHeightText) {
        assertDoesNotThrow(() -> new LadderGame(participantsText, maxLadderHeightText));
    }
}