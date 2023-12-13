package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    @DisplayName("Participant 리스트를 전달하면 Participants 객체를 생성한다.")
    @Test
    void participantsTest() {
        assertThat(new Participants(List.of(new Participant("이름1"), new Participant("이름2")))).isInstanceOf(Participants.class);
    }

    @DisplayName(",로 구분된 참가자 이름들을 전달하면 Participants 객체를 생성한다.")
    @Test
    void participantsStringTest() {
        assertThat(Participants.from("name1,name2")).isInstanceOf(Participants.class);
    }

    @DisplayName("생성된 Participants의 크기를 확인할 수 있다.")
    @Test
    void sizeTest() {
        Participants participants = Participants.from("name1,name2,name3");

        assertThat(participants.size()).isEqualTo(3);
    }

    @DisplayName("index를 넘기면 해당 위치의 참가자를 반환한다.")
    @Test
    void getParticipantTest() {
        Participant participant1 = new Participant("참가자1");
        Participant participant2 = new Participant("참가자2");
        Participants participants = new Participants(List.of(participant1, participant2));

        assertThat(participants.getParticipant(1)).isEqualTo(participant2);
    }
}
