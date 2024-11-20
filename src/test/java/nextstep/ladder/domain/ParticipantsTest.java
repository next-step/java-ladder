package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

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
}
