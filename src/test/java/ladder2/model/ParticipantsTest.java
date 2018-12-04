package ladder2.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    public static Participants DEFAULT_PARTICIPANTS = Participants.fromComma("pobi,honux,crong,jk");

    @Test
    public void 생성() {
        assertThat(DEFAULT_PARTICIPANTS.size()).isEqualTo(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_0명() {
        Participants.fromComma("");
    }
}