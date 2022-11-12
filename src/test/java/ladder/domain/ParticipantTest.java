package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    @DisplayName("changePosition 메소드는 참가자의 위치를 변경한다.")
    void changePosition() {
        Participant participant = new Participant("jordy", 1);
        participant.changePosition(5);

        assertThat(participant).isEqualTo(new Participant("jordy", 5));
    }
}