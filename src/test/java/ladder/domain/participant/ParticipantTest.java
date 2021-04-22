package ladder.domain.participant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("Participant 인스턴스 생성 테스트")
    @Test
    void 생성() {
        // given
        String name = "woji";

        // when
        Participant participant = Participant.of(name);

        // then
        assertThat(participant).isNotNull();
    }
}