package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParticipantsTest {
    Participant pobi = new Participant("pobi");
    Participant honux = new Participant("honux");
    Participant crong = new Participant("crong");
    Participant jk = new Participant("jk");
    Participant tomo = new Participant("tomo");
    Participants participants = new Participants(Arrays.asList(pobi, honux, crong, jk));

    @DisplayName("Test whether Ids of Participants are exact")
    @Test
    void testIds() {
        assertThat(participants.initialPosition(pobi)).isEqualTo(new Position(0));
        assertThat(participants.initialPosition(honux)).isEqualTo(new Position(1));
        assertThat(participants.initialPosition(crong)).isEqualTo(new Position(2));
        assertThat(participants.initialPosition(jk)).isEqualTo(new Position(3));
    }

    @DisplayName("Throw Exception when there is no participant")
    @Test
    void testWhenThereIsNoParticipant() {
        assertThatThrownBy(() -> participants.initialPosition(tomo)).isInstanceOf(NoSuchElementException.class);
    }
}
