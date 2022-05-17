package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {
    @ParameterizedTest
    @NullSource
    @DisplayName("사람 이름이 null 인 경우 예외가 발생한다.")
    void Participant_사람이름_null(Name name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }
}