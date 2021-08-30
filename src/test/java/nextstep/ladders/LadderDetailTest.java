package nextstep.ladders;

import nextstep.ladders.exception.DifferentCountException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderDetailTest {

    @ParameterizedTest
    @CsvSource(value = {"참가자1,참가자2:5000", "참가자1:5000,꽝"}, delimiter = ':')
    void 참가자와_실행결과의_개수가_일치하지_않을경우_에러(final String participantsText, final String executionResultText) {
        assertThrows(DifferentCountException.class, () -> new LadderDetail(participantsText, executionResultText));
    }
}