package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Participant.INVALID_PARTICIPANT_NAME_LENGTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantsTest {

    @Test
    @DisplayName("Participants.of 정적 메서드로 Participants 객체 정상 생성")
    void testParticipants_of_ShouldReturnParticipants() {
        List<String> names = List.of("java", "dart", "go");
        Participants participants = Participants.of(names);

        assertThat(participants.getNumberOfParticipants()).isEqualTo(3);
        assertAll(
                () -> assertEquals("java", participants.getParticipants().get(0).getParticipant()),
                () -> assertEquals("dart", participants.getParticipants().get(1).getParticipant()),
                () -> assertEquals("go", participants.getParticipants().get(2).getParticipant())
        );
    }

    @Test
    @DisplayName("Participants.of 정적 메서드로 Participants 객체 생성시, 최대 이름 길이를 초과한 값이 들어와 에러 반환")
    void testParticipants_of_overNameLengthFive_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participants.of(List.of("Python","lambda"));
        }).withMessageContaining(INVALID_PARTICIPANT_NAME_LENGTH);
    }
}
