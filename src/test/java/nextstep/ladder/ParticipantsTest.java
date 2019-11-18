package nextstep.ladder;

import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantsTest {

    @Test
    void positionTest() {
        Participants participants = new Participants(Arrays.asList("one", "two", "three"));

        assertThat(participants.getPositions("one").contains(0)).isTrue();
        assertThat(participants.getPositions("two").contains(1)).isTrue();
        assertThat(participants.getPositions("three").contains(2)).isTrue();
        assertThat(participants.getPositions("all").containsAll(Arrays.asList(0, 1, 2))).isTrue();
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
