package nextstep.ladder.domain;

import nextstep.ladder.exceptions.ParticipantsAndResultsNumberNotMatchedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultsTest {

    @Test
    @DisplayName("ParticipantsAndResultsNumberNotMatchedException")
    void exception() {
        assertThatExceptionOfType(ParticipantsAndResultsNumberNotMatchedException.class)
                .isThrownBy(() -> new Results(new String[]{"a", "b"}, 3))
                .withMessage("참가자 수와 사다리 타기 결과의 수는 일치해야 합니다.");
    }

}