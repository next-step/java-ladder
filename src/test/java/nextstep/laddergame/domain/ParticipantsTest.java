package nextstep.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParticipantsTest {

    @Test
    void create() {
        Participants participants = new Participants("aaa,bbb,ccc");
        assertThat(participants.getParticipants().size()).isEqualTo(3);
    }
}
