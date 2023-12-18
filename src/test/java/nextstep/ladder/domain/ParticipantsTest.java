package nextstep.ladder.domain;

import nextstep.ladder.exception.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자가 여러명인 경우 자동으로 현재 위치를 가지고 있는다.")
    void participantsPositionTest() {
        Participants participants = new Participants("a,b");
        assertThat(participants.getParticipants().get(0).getPosition()).isEqualTo(1);
        assertThat(participants.getParticipants().get(1).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("참가자 명단에 없는 이름을 입력하는 경우 Exception 발생")
    void wrongInputParticipantName() {
        Participants participants = new Participants("a,b");
        assertThrows(NotFoundException.class, () -> participants.getParticipantByName("c"));
    }

}
