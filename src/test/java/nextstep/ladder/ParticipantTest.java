package nextstep.ladder;

import nextstep.ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParticipantTest {
    @Test
    @DisplayName("이름을 입력했을 떄, 5자가 넘으면 Exception을 발생한다.")
    void assertParticipantNameLength() {
        String name = "yeoseon";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participant(name);
        }).withMessage(Participant.PARTICIPANT_NAME_LENGTH_ERROR);
    }
}
