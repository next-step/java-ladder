package ladder.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    @ParameterizedTest
    @ValueSource(strings = {"a","bb","ccc","dddd","eeeee"})
    void canGenerateparticipant(String input){
        Participant participant = new Participant(input);
        assertThat(input).isEqualTo(input);
    }
}
