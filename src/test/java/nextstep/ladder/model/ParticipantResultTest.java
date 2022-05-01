package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("참가자 결과")
class ParticipantResultTest {

    @Test
    @DisplayName("참가자와 결과로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> ParticipantResult.of(Participant.from("a"), Result.from("100")));
    }

    @Test
    @DisplayName("참가자와 결과는 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> ParticipantResult.of(null, Result.from("100")));
        assertThatIllegalArgumentException().isThrownBy(() -> ParticipantResult.of(Participant.from("a"), null));
    }

    @Test
    @DisplayName("참가와 결과는 그대로 반환")
    void participant_result() {
        //given
        Participant aParticipant = Participant.from("a");
        Result oneHundred = Result.from("100");
        ParticipantResult participantResult = ParticipantResult.of(aParticipant, oneHundred);
        //when, then
        assertAll(
                () -> assertThat(participantResult.participant()).isEqualTo(aParticipant),
                () -> assertThat(participantResult.result()).isEqualTo(oneHundred)
        );
    }
}
