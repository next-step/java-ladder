package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class ParticipantTest {

    @Test
    void 참여자_이름_5자초과_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participant.of("abcdef");
        });
    }

    @Test
    void 참여자의_이름이_같다면_같은_참여자이다() {
        assertThat(Participant.of("java")).isEqualTo(Participant.of("java"));
    }
}
