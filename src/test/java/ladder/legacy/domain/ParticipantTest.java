package ladder.legacy.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    void participant_creation_test() {
        String input = "abcdefg";

        assertThatThrownBy(() -> Participant.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void participant_toString_test() {
        String input = "tdd";
        Participant participant = Participant.of(input);

        assertThat(participant.toString().equals(input)).isTrue();
    }

    @Test
    void participant_equals_test() {
        String input = "tdd";
        Participant participant = Participant.of(input);

        assertThat(participant.equals(Participant.of(input))).isTrue();
    }
}
