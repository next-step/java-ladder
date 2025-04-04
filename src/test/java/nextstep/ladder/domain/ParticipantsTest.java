package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    @Test
    void create() {
        assertThat(new Participants(new String[]{"p1", "p2"})).isEqualTo(new Participants(List.of("p1", "p2")));
    }

    @Test
    void null_empty_name() {
        assertThatThrownBy(() -> new Participants(new String[]{"", " "}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.NULL_OR_EMPTY_ERROR_MESSAGE);
    }

    @Test
    void invalid_name() {
        assertThatThrownBy(() -> new Participants(new String[]{"p123", "p123456"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.TOO_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void invalid_name_size() {
        assertThatThrownBy(() -> new Participants(new String[]{"p123"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.TOO_FEW_PARTICIPANTS_MESSAGE);
    }

    @Test
    void valid_name() {
        assertThat(new Participants(new String[]{"p1", "p2"})).isInstanceOf(Participants.class);
    }
}
