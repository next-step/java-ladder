package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class NameTest {
    private static final String PARTICIPANT_ONE_NAME = "tomo";
    private static final String PARTICIPANT_TWO_NAME = "sans";
    private static final String PARTICIPANT_THREE = "michael";

    @Test
    @DisplayName("Check participant name is OK")
    void nameIsOK() {
        Name participantOne = new Name(PARTICIPANT_ONE_NAME);

        assertThat(participantOne).isEqualTo(new Name(PARTICIPANT_ONE_NAME));
        assertThat(participantOne).isNotEqualTo(PARTICIPANT_TWO_NAME);
    }

    @Test
    @DisplayName("Check the length of participant name is not over five")
    void nameWhoseLengthIsOverFiveThrowsException() {
        assertThatThrownBy(() -> new Name(PARTICIPANT_THREE)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Check participant instance name")
    void checkString() {
        Name participantOne = new Name(PARTICIPANT_ONE_NAME);
        assertThat(participantOne.getName()).isEqualTo(PARTICIPANT_ONE_NAME);
    }
}
