package ladder.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
    void canGenerateParticipant(String input) {
        Participant participant = new Participant(input);
        assertThat(participant.name()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"a", "bb", "ccc", "dddd", "eeeee"}, delimiter = ',')
    void canTrimWhiteSpaces(String input){
        String whiteSpaceAddedInput = String.format("     %s   ", input);
        Participant participant = new Participant(whiteSpaceAddedInput);
        assertThat(participant.name()).isEqualTo(input);
    }
}
