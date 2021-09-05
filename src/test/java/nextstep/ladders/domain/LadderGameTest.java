package nextstep.ladders.domain;

import nextstep.ladders.exception.DifferentCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {

    @ParameterizedTest
    @CsvSource(value = {"참가자1,참가자2:5000", "참가자1:5000,꽝"}, delimiter = ':')
    @DisplayName("참가자와 실행 결과의 개수가 일치하지 않을경우 에러")
    void ifTheNumberOfParticipantsAndTheNumberOfExecutionResultsDoNotMatchAnErrorOccurs(final String participantsText, final String executionResultText) {
        assertThrows(DifferentCountException.class, () -> new LadderGame(participantsText, executionResultText));
    }
}