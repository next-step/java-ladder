package ladder;

import ladder.model.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("참여자 수, 사다리 높이 기준으로 사다리를 생성한다")
    @Test
    void create() {
        Ladder ladder = Ladder.of(4, 5);
        assertThat(ladder.size()).isEqualTo(5);
    }
}
