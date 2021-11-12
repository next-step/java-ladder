package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class NameTest {
    private final String PARTICIPANT_ONE_NAME = "tomo";
    private final String PARTICIPANT_TWO_NAME = "sans";
    private final String PARTICIPANT_THREE = "michael";

    @Test
    void nameIsOK() {
        Name participantOne = new Name(PARTICIPANT_ONE_NAME);

        assertThat(participantOne).isEqualTo(new Name(PARTICIPANT_ONE_NAME));
        assertThat(participantOne).isNotEqualTo(PARTICIPANT_TWO_NAME);
    }

    @Test
    void nameWhoseLengthIsOverFiveThrowsException() {
        assertThatThrownBy(() -> new Name(PARTICIPANT_THREE)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkString() {
        Name participantOne = new Name(PARTICIPANT_ONE_NAME);
        assertThat(participantOne.getName()).isEqualTo(PARTICIPANT_ONE_NAME);
    }
}
