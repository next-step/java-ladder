package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    void 참여자그룹() {
        String input = "pobi,honux,crong,jk";
        assertThat(Participants.from(input).count()).isEqualTo(4);
    }
}

