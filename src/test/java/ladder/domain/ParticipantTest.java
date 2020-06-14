package ladder;

import ladder.domain.Participant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    void initParticipantTest() {
        Participant participant = new Participant();
        assertThat(participant.getClass().getSimpleName()).isEqualTo("Participant");
    }

    @Test
    void initParticipantNameTest() {
        String name = "DongHyuk";
        Participant participant = new Participant(name);
        assertThat(participant.getName()).isEqualTo(name);
    }


}
