package nextstep.ladder;

import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {

    @Test
    void positionTest() {
        Participants participants = new Participants(Arrays.asList("one", "two", "three"));

        assertThat(participants.match("one").get(0)).isEqualTo(new Participant("one", 0));
        assertThat(participants.match("two").get(0)).isEqualTo(new Participant("two", 1));
        assertThat(participants.match("three").get(0)).isEqualTo(new Participant("three", 2));
        assertThat(participants.match("all").size()).isEqualTo(3);
    }

    @Test
    void exceptionTest() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants(Arrays.asList("person1"));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants(Arrays.asList("person1", "person2", "all"));
        });
    }
}
