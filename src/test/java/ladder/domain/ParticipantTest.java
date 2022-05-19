package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {
    @DisplayName("Participant 객체 정상 생성 테스트")
    @Test
    void from() {
        assertThat(Participant.from("pobi")).isNotNull();
    }
}