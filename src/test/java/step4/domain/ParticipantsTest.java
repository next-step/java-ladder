package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantsTest {

    @Test
    void 이름으로_참여자_위치를_찾는다() {
        //given
        Participants participants = Participants.of("a,b,c,d");
        //when
        int index = participants.indexOf("a");
        //then
        assertThat(index).isEqualTo(0);
    }
}