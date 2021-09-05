package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리는 입력 받은 높이 만큼의 라인을 갖는다.")
    @Test
    public void ladderHeightTest() {
        int height = 5;
        Players players = Players.of(Arrays.asList("abc", "def"));
        LadderHeights ladderHeights = LadderHeights.of(height);
        Ladder ladder = Ladder.of(players, ladderHeights);
        assertThat(ladder.height())
                .isEqualTo(height);
    }

}