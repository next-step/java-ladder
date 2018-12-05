package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    @Test
    public void 생성() {
        Participants participants = Participants.from("aaa,bbb,ccc");

        assertThat(participants.size()).isEqualTo(3);
    }
}