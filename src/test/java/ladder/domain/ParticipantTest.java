package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @Test
    void 참여자() {
        assertThat(Participant.from("pobi")).isNotNull();
    }

    @Test
    void 참여자_이름_5글자초과() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participant.from("abcdef");
        });
    }
}