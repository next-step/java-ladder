package nextstep.ladder.participant;

import nextstep.ladder.domain.participant.Participant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantTest {
    @Test
    @DisplayName("참여자 이름이 없을 경우 exception")
    void emptyNameParticipant() {
        Assertions.assertThatThrownBy(() -> new Participant(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
