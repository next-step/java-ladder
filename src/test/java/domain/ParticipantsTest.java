package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void 참여자_생성() {
        Participants participants = Participants.fromInput("aaa,sss,ddd");

        assertThat(participants.countOfParticipants()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_이름_5자_넘으면_Exception() {
        Participants.fromInput("aaaaaa");
    }

    @Test
    public void 참여자의_index_반환() {
        Participants participants = Participants.fromInput("aaa,bbb,ccc,ddd");

        assertThat(participants.indexOf(new Participant("aaa"))).isEqualTo(0);

        // 참여자가 없으면 -1
        assertThat(participants.indexOf(new Participant("fff"))).isEqualTo(-1);
    }
}
