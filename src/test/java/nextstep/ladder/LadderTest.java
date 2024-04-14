package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("입력된 height 만큼 사다리 길이를 만든다")
    void MAKE_LADDER_WITH_INPUT_HEIGHT() {
        assertThat(Ladder.generateLadder(3, 5).size()).isEqualTo(5);
    }
}
