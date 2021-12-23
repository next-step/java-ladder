package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {

    @Test
    @DisplayName("String 값을 입력 받아 Participant 객체를 생성한다")
    void shouldCreate() {
        String input = "pobi";
        Participant participant = Participant.from(input);

        assertThat(participant).isEqualTo(Participant.from(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"dodeon"})
    void shouldThrowWhenInvalidInput(String input) {
        assertThatThrownBy(() -> Participant.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}