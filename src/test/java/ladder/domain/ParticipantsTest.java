package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    @DisplayName("참가자 생성 테스트")
    public void initParticipantsTest() {
        Participants participants = new Participants(Arrays.asList("a", "b", "c"));

        assertThat(participants.getParticipantsCount()).isEqualTo(3);
    }
}
