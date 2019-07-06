package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {
    @Test
    @DisplayName("참가자는 이름으로 생성된다.")
    void new_WithName_Created() {
        final String name = "yong";
        final Participant participant = new Participant(name);
        assertThat(participant).isInstanceOf(Participant.class);
    }

    @Test
    @DisplayName("참가자의 이름이 5자를 넘으면 예외가 발생한다.")
    void new_WithNameOver5Length_ExceptionThrown() {
        final String name = "123456";
        assertThatThrownBy(() -> new Participant(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
