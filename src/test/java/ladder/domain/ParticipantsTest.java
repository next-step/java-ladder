package ladder.domain;

import ladder.domain.user.Participant;
import ladder.domain.user.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    private static Participants makeParticipants() {
        Participant participant1 = new Participant("pobi");
        Participant participant2 = new Participant("honux");
        Participant participant3 = new Participant("crong");
        Participant participant4 = new Participant("jk");
        return new Participants(participant1, participant2, participant3, participant4);
    }

    @Test
    @DisplayName("참여자 리스트 반환 메소드 확인")
    void testIfGetDesireParticipant() {
        Participants participants = makeParticipants();

        Participants expectedResult = new Participants(Arrays.asList(new Participant("pobi")));
        assertThat(participants.getDesireParticipants("pobi")).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("참여자 전체 리스트 반환 메소드 확인")
    void testIfGetDesireAllParticipants() {
        Participants participants = makeParticipants();

        Participants expectedResult = makeParticipants();
        assertThat(participants.getDesireParticipants("all")).isEqualTo(expectedResult);
    }
}
