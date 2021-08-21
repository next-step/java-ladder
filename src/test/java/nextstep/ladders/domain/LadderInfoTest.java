package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.DifferentCountException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderInfoTest {


    @ParameterizedTest
    @CsvSource(value = {"pobi,aa:꽝", "pobi:5000,꽝"}, delimiter = ':')
    void 참가자와_실행결과의_개수가_일치하지_않을경우_에러(final String participantsText, final String executionResultText) {
        assertThrows(DifferentCountException.class, () -> new LadderInfo(participantsText, executionResultText));
    }
}