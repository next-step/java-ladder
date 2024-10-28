package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantTest {

    @Test
    public void create() {
        Participant participant = new Participant("3");
        assertThat(participant).isEqualTo(new Participant("3"));
    }

    @Test
    public void split() {
        Participants participant = new Participants("pobbi,conan,test");
        assertThat(participant.getParticipants()).hasSize(3);
    }

    @Test
    public void empty() {
        assertThatThrownBy(() -> {
            Participant participant = new Participant("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void nameOverFiveLength() {
        assertThatThrownBy(() -> {
            Participants participants  = new Participants("ABCDEFG,I,J");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void nameDuplication() {
        assertThatThrownBy(() -> {
            Participants participants  = new Participants("A,A,A,A,A");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
