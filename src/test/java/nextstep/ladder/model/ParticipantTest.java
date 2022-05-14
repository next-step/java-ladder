package nextstep.ladder.model;

import nextstep.ladder.model.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParticipantTest {


    @ParameterizedTest
    @DisplayName("참가자의 이름의 길이는 1자리에서 5자리입니다.")
    @ValueSource(strings = {"", "kkkkkk"})
    void nameOutOfBounds(String input) {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            new Participant(input);
        });
    }

    @Test
    @DisplayName("참가자의 이름은 null일 수 없습니다.")
    void nameNullPointException() {
        assertThrows(NullPointerException.class, () -> {
            new Participant(null);
        });
    }

    @Test
    @DisplayName("참가자의 이름의 길이를 계산한다.")
    void lengthTest() {
        Participant participant = new Participant("klom");
        assertThat(participant.getName()).isEqualTo(" klom");
    }
}
