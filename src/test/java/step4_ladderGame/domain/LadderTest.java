package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("입력한 높이 만큼 사다리를 생성한다.")
    @Test
    void testCase1() {
        Ladder ladder = Ladder.initLadder(5, 5, RandomPointStrategy.getInstance());

        Assertions.assertThat(ladder.size()).isEqualTo(5);
    }
}