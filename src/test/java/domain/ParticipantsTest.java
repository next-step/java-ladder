package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {

    public static final Participants DEFAULT_PARTICIPANTS = Participants.from("aaa,bbb,ccc");

    @Test
    public void 생성() {
        Participants participants = Participants.from("aaa,bbb,ccc");

        assertThat(participants.size()).isEqualTo(3);
    }
}