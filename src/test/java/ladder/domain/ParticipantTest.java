package ladder.domain;

import ladder.exception.CreatingParticipantFailureException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParticipantTest {

    @ParameterizedTest(name = "참가자 생성 테스트 - {0}")
    @ValueSource(strings = {"woody", "jacob", "tate"})
    void create(final String personName) {
        Participant participant = assertDoesNotThrow(() -> new Participant(personName));
        assertThat(participant).isEqualTo(new Participant(personName));
    }

    @ParameterizedTest(name = "참가자 생성 실패 테스트 - {0}")
    @NullSource
    @ValueSource(strings = {"hannah"})
    void invalidName(final String personName) {
        assertThatThrownBy(() -> new Participant(personName))
                .isInstanceOf(CreatingParticipantFailureException.class)
                .hasMessageContaining("1")
                .hasMessageContaining("5");
    }
}
