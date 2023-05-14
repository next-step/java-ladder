package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    @DisplayName("Participants_테스트")
    public void Participants_테스트(){
        String[] names = {"test", "test2", "test3"};
        Participant participant = new Participant(names);

        Assertions.assertThat(participant.getParticipants()).hasSize(3);
    }
}
