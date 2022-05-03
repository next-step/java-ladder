package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ParticipantsTest {

    @DisplayName("Participants의 이름은 중복일 수 없다")
    @Test
    void duplicateValidation() {
        assertThatThrownBy(() -> Participants.createParticipants(List.of("a", "a")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void swapWithNext() {
        Participants participants = Participants.createParticipants(List.of("a", "b", "c", "d"));

        participants.swapWithNext(2);

        assertThat(participants.getParticipants())
                .containsExactly(new Participant("a"),
                        new Participant("b"),
                        new Participant("d"),
                        new Participant("c"));
    }
}
