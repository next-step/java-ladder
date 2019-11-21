package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantTest {

    @Test
    void exceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participant("name12", 0);
        });
    }
}
