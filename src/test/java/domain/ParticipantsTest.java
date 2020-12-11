package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    private Participants participants;

    @Test
    @DisplayName("of() test")
    void ofTest() {
        assertThat(participants.of("a,b,c,d,e").size()).isEqualTo(5);
    }
}
