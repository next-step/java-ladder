package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantTest {

    @Test
    void exceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participant("name12");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants(Arrays.asList("person1"));
        });
    }
}
