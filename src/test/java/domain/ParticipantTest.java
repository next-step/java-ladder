package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantTest {
    private static final String PARTICIPANT_ONE_NAME = "tomo";
    private static final String PARTICIPANT_TWO_NAME = "sans";
    private static final String PARTICIPANT_THREE_NAME = "michael";

    Participant participantOne = new Participant(PARTICIPANT_ONE_NAME);
    Participant participantTwo = new Participant(PARTICIPANT_TWO_NAME);

    @Test
    @DisplayName("Compare different instance with the same name")
    void testEqual() {
        assertThat(participantOne).isEqualTo(new Participant(PARTICIPANT_ONE_NAME));
    }

    @Test
    @DisplayName("Compare different instance with different names")
    void testNotEqual() {
        assertThat(participantOne).isNotEqualTo(participantTwo);
    }
}
