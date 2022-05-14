package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantTest {
    @ParameterizedTest
    @NullSource
    void Participant_사람이름이_null_인_경우(Name name) {
        assertThatThrownBy(() -> new Participant(name)).isInstanceOf(IllegalArgumentException.class);
    }
}