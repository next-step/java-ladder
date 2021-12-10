package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("of 메소드로 participants 가 잘 만들어지는지 테스트")
    void ofTest() {
        List<Participant> participantList = new ArrayList<Participant>();
        participantList.add(Participant.of("t1"));
        participantList.add(Participant.of("t2"));
        participantList.add(Participant.of("t3"));

        Participants participants = Participants.of("t1,t2,t3");
        for (int index = 0; index < participants.getParticipantsSize(); index++) {
            assertThat(participants.getParticipants().get(index)).isEqualTo(participantList.get(index));
        }
    }
}
