package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

    @Test
    void 참가자수는_2명_이상이어야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participants.of(Collections.singletonList("abc"));
        }).withMessage("참가자 수가 유효하지 않습니다.");
    }

    @Test
    void 두명_이상_참가자수로_참가자들_생성테스트() {
        assertThat(Participants.of(Arrays.asList("aa", "bb", "cc")).getNumberOfParticipants()).isEqualTo(3);
    }
}