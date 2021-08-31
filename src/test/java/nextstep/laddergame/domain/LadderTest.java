package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리는 입력 받은 높이 만큼의 라인을 갖는다.")
    @Test
    public void ladderHeightTest() {
        int countOfPlayer = 3;
        int height = 5;
        Ladder ladder = Ladder.of(countOfPlayer, height);
        assertThat(ladder.height())
                .isEqualTo(height);
    }

}