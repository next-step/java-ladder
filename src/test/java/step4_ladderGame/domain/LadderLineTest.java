package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

    @DisplayName("플레이어 수에 따라 Point를 생성한다.")
    @Test
    void testCase1() {
        int playerCount = 5;
        LadderLine line = LadderLine.initLadderLine(playerCount);

        Assertions.assertThat(line.size()).isEqualTo(5);
    }
}