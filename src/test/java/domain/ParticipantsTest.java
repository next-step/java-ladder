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
    public static final Participant PARTICIPANT_FOUR = new Participant("jk");
    public static final Participant NOT_PARTICIPANT = new Participant("tomo");
    public static final Participants PARTICIPANTS = new Participants(Arrays.asList(PARTICIPANT_ONE, PARTICIPANT_TWO, PARTICIPANT_THREE, PARTICIPANT_FOUR));

    @DisplayName("Test whether Ids of Participants are exact")
    @Test
    void testIds() {
        assertThat(PARTICIPANTS.initialPosition(PARTICIPANT_ONE)).isEqualTo(new Position(0));
        assertThat(PARTICIPANTS.initialPosition(PARTICIPANT_TWO)).isEqualTo(new Position(1));
        assertThat(PARTICIPANTS.initialPosition(PARTICIPANT_THREE)).isEqualTo(new Position(2));
        assertThat(PARTICIPANTS.initialPosition(PARTICIPANT_FOUR)).isEqualTo(new Position(3));
    }

    @DisplayName("Throw Exception when there is no participant")
    @Test
    void testWhenThereIsNoParticipant() {
        assertThatThrownBy(() -> PARTICIPANTS.initialPosition(NOT_PARTICIPANT)).isInstanceOf(NoSuchElementException.class);
    }
}
