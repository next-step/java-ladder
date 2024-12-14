package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    void split_참가자_한명() {
        Participants participants = new Participants("한명");
        assertThat(participants.size()).isEqualTo(1);
    }

    @Test
    void split_참가자_여러명() {
        Participants participants = new Participants("a,b,c,d,e");
        assertThat(participants.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("참여자의 결과를 구함")
    void getParticipantResult() {
        Participant participant1 = new Participant("a", new Position(1,3), "당첨");
        Participant participant2 = new Participant("b", new Position(1,3), "꽝");
        List<Participant> participantList  = new ArrayList<>();
        participantList.add(participant1);
        participantList.add(participant2);

        Participants participants = new Participants(participantList);
        participants.getParticipantResult("a");
        assertThat(participants.getParticipant(0).getResult()).isEqualTo("당첨");
        assertThat(participants.getParticipant(1).getResult()).isEqualTo("꽝");
    }

}
