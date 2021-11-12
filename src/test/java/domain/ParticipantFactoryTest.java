package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParticipantFactoryTest {
    private final String PARTICIPANT_ONE_NAME = "tomo";
    private final String PARTICIPANT_TWO_NAME = "sans";
    private final String PARTICIPANT_THREE_NAME = "dane";

    private final int SIZE_OF_PARTICIPANTS = 3;

    private final String[] input = new String[]{PARTICIPANT_ONE_NAME, PARTICIPANT_TWO_NAME, PARTICIPANT_THREE_NAME};

    private final Participants participants = new Participants();

    @BeforeEach
    void setUp() {
        participants.add(new Participant(PARTICIPANT_ONE_NAME));
        participants.add(new Participant(PARTICIPANT_TWO_NAME));
        participants.add(new Participant(PARTICIPANT_THREE_NAME));
    }

    @Test
    void testProduceParticipants() {
        ParticipantFactory participantFactory = new ParticipantFactory(input);
        Participants produced = participantFactory.produceParticipants();

        assertThat(produced.isSizeEqualTo(SIZE_OF_PARTICIPANTS)).isTrue();
    }
}
