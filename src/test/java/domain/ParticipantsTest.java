package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantsTest {
    private static final String PARTICIPANT_ONE_NAME = "tomo";
    private static final String PARTICIPANT_TWO_NAME = "sans";
    private static final String PARTICIPANT_THREE = "michael";

    private static final Participant PARTICIPANT_ONE = new Participant(PARTICIPANT_ONE_NAME);
    private static final Participant PARTICIPANT_TWO = new Participant(PARTICIPANT_TWO_NAME);

    private static final int PARTICIPANTS_SIZE = 2;
    private static final List<String> names = Arrays.asList(PARTICIPANT_ONE_NAME, PARTICIPANT_TWO_NAME);
    private static final String[] input = new String[]{PARTICIPANT_ONE_NAME, PARTICIPANT_TWO_NAME};

    private Participants participants;

    @BeforeEach
    void setUp() {
        participants = new Participants(input);
        participants.produceParticipants();
    }

    @Test
    @DisplayName("Test getNamesOfParticipants function")
    void testProvideParticipantsNames() {
        assertThat(participants.getNamesOfParticipants()).isEqualTo(names);
    }

    @Test
    @DisplayName("Test produceParticipants function")
    void testProduceParticipants() {
        assertThat(participants.size()).isEqualTo(PARTICIPANTS_SIZE);
    }
}
