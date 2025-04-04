package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {
    @Test
    void create() {
        assertThat(new Participant("p1")).isInstanceOf(Participant.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void null_empty_name(String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.NULL_OR_EMPTY_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdefghi"})
    void invalid_name(String input) {
        assertThatThrownBy(() -> new Participant(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participant.TOO_LENGTH_ERROR_MESSAGE);
    }
}
