package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantTest {
    private final String PARTICIPANT_ONE_NAME = "tomo";
    private final String PARTICIPANT_TWO_NAME = "sans";
    private final String PARTICIPANT_THREE_NAME = "michael";

    Participant participantOne = new Participant(PARTICIPANT_ONE_NAME);
    Participant participantTwo = new Participant(PARTICIPANT_TWO_NAME);

    @Test
    void testEqual() {
        assertThat(participantOne).isEqualTo(new Participant(PARTICIPANT_ONE_NAME));
    }

    @Test
    void testNotEqual() {
        assertThat(participantOne).isNotEqualTo(participantTwo);
    }
}
