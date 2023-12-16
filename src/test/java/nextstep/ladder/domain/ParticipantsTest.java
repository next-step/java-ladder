package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자가 여러명인 경우 자동으로 현재 위치를 가지고 있는다.")
    void participantsPositionTest() {
        Participants participants = new Participants("a,b");
        assertThat(participants.getParticipants().get(0).getPosition()).isEqualTo(1);
        assertThat(participants.getParticipants().get(1).getPosition()).isEqualTo(2);
    }
}
