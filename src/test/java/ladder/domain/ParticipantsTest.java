package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    void participants_creation_test() {
        String input = "pobi,honux,crong,jk";

        String[] split = input.split(",");

        Participants participants = Participants.of(input);
        assertThat(participants.getSize()).isEqualTo(split.length);
    }

    @Test
    void participants_exception_test() {
        String input = "";
        assertThatThrownBy(() -> Participants.of(input))
                .isInstanceOf(NullPointerException.class);
    }
}
