package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        assertThat(participants.size()).isEqualTo(5);
    }
}