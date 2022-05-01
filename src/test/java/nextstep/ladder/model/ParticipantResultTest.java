package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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
    @DisplayName("주어진 참가자 그대로 반환")
    void participant() {
        //given
        Participant aParticipant = Participant.from("a");
        //when, then
        assertThat(ParticipantResult.of(aParticipant, Result.from("100")).participant()).isEqualTo(aParticipant);
    }

    @Test
    @DisplayName("주어진 결과 그대로 반환")
    void result() {
        //given
        Result oneHundred = Result.from("100");
        //when, then
        assertThat(ParticipantResult.of(Participant.from("a"), oneHundred).result()).isEqualTo(oneHundred);
    }
}
