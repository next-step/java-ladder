package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {
    public static final Participant PARTICIPANT_ONE = new Participant("pobi");
    public static final Participant PARTICIPANT_TWO = new Participant("honux");
    public static final Participant PARTICIPANT_THREE = new Participant("crong");
    public static final Participants PARTICIPANTS = new Participants(Arrays.asList(PARTICIPANT_ONE, PARTICIPANT_TWO, PARTICIPANT_THREE));


    @DisplayName("Throw Exception when there is no participant")
    @Test
    void testWhenThereIsNoParticipant() {
        assertThatThrownBy(() -> PARTICIPANTS.initialPosition("tomo")).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void testInitialPosition() {
        assertThat(PARTICIPANTS.initialPosition("pobi")).isEqualTo(0);
        assertThat(PARTICIPANTS.initialPosition("honux")).isEqualTo(1);
        assertThat(PARTICIPANTS.initialPosition("crong")).isEqualTo(2);
    }
}
