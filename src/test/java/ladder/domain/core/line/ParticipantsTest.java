package ladder.domain.core.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.core.line.Participant;
import ladder.domain.core.line.Participants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @DisplayName("참가자들는 쉼표를 기준으로 공백이나 null일수 없음")
    @Test
    void blankParticipantsTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants(null))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants(" "))
            .withMessage(Participant.ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("잘못된 참가자 이름이 있는 경우 예외 처리")
    @Test
    void suitableNameCheckTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants("123"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participants("a12345"))
            .withMessage(Participant.ERROR_MESSAGE_SUITABLE_NAME);
    }


    @DisplayName("참가자들는 쉼표를 기준으로 구분함")
    @Test
    void participantsTest() {
        assertThat(new Participants("pobi,honux,crong,jk").getCount()).isEqualTo(4);
    }
}
