package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {

    @ParameterizedTest(name = "Participant 생성. name={0}")
    @ValueSource(strings = {
            "crong",
            "cr",
    })
    void newParticipant(String name) {

        assertThat(new Participant(name).getName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "Participant 생성시 exception 발생. name=[{0}]")
    @NullAndEmptySource
    @ValueSource(strings = "crong123")
    void newParticipantOccurredException(String name) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participant(name));
    }
}