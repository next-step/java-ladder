package ladder.domain;

import ladder.exception.InvalidParticipantNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("참가자들의 명수 반환")
    void getParticipantsSizeTest() {
        Participants participants = new Participants(List.of(
                new Participant("a"),
                new Participant("b"),
                new Participant("c"),
                new Participant("d"),
                new Participant("e")
        ));
        assertThat(participants.getParticipants().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("참가자들의 수가 두명 이하이면 InvalidParticipantsNumberException 발생")
    void throwInvalidParticipantsNumberExceptionTest() {
        assertThatThrownBy(() -> new Participants(List.of()))
                .isInstanceOf(InvalidParticipantNumberException.class);

        assertThatThrownBy(() -> new Participants(List.of(new Participant("a"))))
                .isInstanceOf(InvalidParticipantNumberException.class);
    }
}