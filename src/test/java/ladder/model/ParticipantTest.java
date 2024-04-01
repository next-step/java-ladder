package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.model.Participant.INVALID_PARTICIPANT_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {

    @Test
    @DisplayName("Participant.of 정적 메서드를 사용해 Participant 객체 정상 생성")
    void testParticipant_of_ShouldReturnParticipant() {
        Participant participant = Participant.of("java");

        assertThat(participant.getParticipant()).isEqualTo("java");
    }

    @Test
    @DisplayName("Participant.of 정적 메서드를 사용해 이름 길이가 5를 초과한 Participant 객체 생성시 에러 반환")
    void testParticipant_of_overNameLengthFive_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participant.of("Python");
        }).withMessageContaining(INVALID_PARTICIPANT_NAME_LENGTH);
    }

}
