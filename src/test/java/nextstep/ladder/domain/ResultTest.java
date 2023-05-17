package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @DisplayName("참여자 수와 실행 결과 수가 일치하지 않으면 예외를 발생한다")
    @Test
    void when_ParticipantsNumIsNotEqualToResultsCount_Expects_ThrowException() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        assertThatThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000,꽝"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수와 실행 결과 수가 일치하면 예외를 발생하지 않는다.")
    @Test
    void when_ParticipantsNumEqualToResultsCount_Expects_DoesNotThrowException() {
        Participants participants = new Participants("pobi,honux,crong,jk");
        assertThatNoException()
                .isThrownBy(() -> Result.of(participants, "꽝,5000,꽝,3000"));
    }
}