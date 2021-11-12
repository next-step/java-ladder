package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantsTest {
    private final String PARTICIPANT_ONE_NAME = "tomo";
    private final String PARTICIPANT_TWO_NAME = "sans";
    private final String PARTICIPANT_THREE = "michael";

    private final Participant PARTICIPANT_ONE = new Participant(PARTICIPANT_ONE_NAME);
    private final Participant PARTICIPANT_TWO = new Participant(PARTICIPANT_TWO_NAME);

    private final int PARTICIPANTS_SIZE = 2;
    private final List<String> names = Arrays.asList(PARTICIPANT_ONE_NAME, PARTICIPANT_TWO_NAME);

    private Participants participants = new Participants();

    @BeforeEach
    void setUp() {
        participants.add(PARTICIPANT_ONE);
        participants.add(PARTICIPANT_TWO);
    }

    @Test
    void testAdd() {
        assertThat(participants.isSizeEqualTo(PARTICIPANTS_SIZE)).isTrue();
    }

    @Test
    void provideParticipantsNames() {
        assertThat(participants.provideParticipantsNames()).isEqualTo(names);
    }
}
