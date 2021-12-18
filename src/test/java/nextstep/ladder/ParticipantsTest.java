package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    @DisplayName("of 메소드로 participants 가 잘 만들어지는지 테스트")
    void ofTest() {
        List<Participant> participantList = new ArrayList<Participant>();
        participantList.add(Participant.of("t1", 0));
        participantList.add(Participant.of("t2", 1));
        participantList.add(Participant.of("t3", 2));

        Participants participants = Participants.of("t1,t2,t3");
        for (int index = 0; index < participants.getParticipantsSize(); index++) {
            assertThat(participants.getParticipants().get(index)).isEqualTo(participantList.get(index));
        }
    }

    @Test
    @DisplayName("checkMinimumNumber 는 2명보다 작은 participants 가 입력되면 2명보다 적은 참가자는 게임할 수 없습니다. 를 반환")
    void checkMinimumNumberTest() {
        assertThatThrownBy(() -> {
            Participants participants = Participants.of("t");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("2명보다 적은 참가자는 게임할 수 없습니다.");
    }
}
