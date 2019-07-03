package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @ParameterizedTest(name = "Participants 객체 생성. input={0}, expectedSize={1}")
    @CsvSource(delimiter = '|', value = {
            "pobi,honux,crong,jk|4",
            "pobi|1",
    })
    void newParticipants(String input, int expectedSize) {

        assertThat(new Participants(input).size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest(name = "Participants 객체 생성시 Exception 발생. input=[{0}]")
    @NullAndEmptySource
    void newParticipantsOccurredException(String input) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(input));
    }
}