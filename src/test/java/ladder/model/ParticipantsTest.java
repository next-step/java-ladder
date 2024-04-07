package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Participant.INVALID_PARTICIPANT_NAME_LENGTH;
import static ladder.model.Participants.NO_MATCHING_PARTICIPANT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantsTest {

    private final Participants participants = Participants.of(List.of("java", "dart", "go"));

    @Test
    @DisplayName("Participants.of 정적 메서드로 Participants 객체 정상 생성")
    void testParticipants_of_ShouldReturnParticipants() {
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

    @Test
    @DisplayName("특정 이름의 참가자가 존재하며 해당 참가자를 조회할 경우, 해당 참가자를 반환")
    void testParticipants_findParticipants_ShouldReturnParticipants() {
        List<Participant> targets = participants.findParticipants("dart");

        assertAll(
                () -> assertEquals(targets.size(), 1),
                () -> assertEquals(targets.get(0).getParticipant(), "dart"),
                () -> assertEquals(targets.get(0).getStartPoint(), 1)
        );
    }

    @Test
    @DisplayName("all로 참가자를 조회할 경우, 해당 참가자를 반환")
    void testParticipants_findAllParticipants_ShouldReturnAllParticipants() {
        List<Participant> targets = participants.findParticipants("all");

        assertEquals(3, targets.size());
        assertAll(
                "java participant exists",
                () -> assertEquals(targets.get(0).getParticipant(), "java"),
                () -> assertEquals(targets.get(0).getStartPoint(), 0)
        );
        assertAll(
                "dart participant exists",
                () -> assertEquals(targets.get(1).getParticipant(), "dart"),
                () -> assertEquals(targets.get(1).getStartPoint(), 1)
        );
        assertAll(
                "go participant exists",
                () -> assertEquals(targets.get(2).getParticipant(), "go"),
                () -> assertEquals(targets.get(2).getStartPoint(), 2)
        );
    }

    @Test
    @DisplayName("존재하지 않는 대상으로 참가자를 조회할 경우, 에러 반환")
    void testParticipants_findNonExistingParticipant_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            participants.findParticipants("lust");
        }).withMessageContaining(NO_MATCHING_PARTICIPANT);
    }

}
