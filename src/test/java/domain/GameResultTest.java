package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @DisplayName("결과를 생성한다.")
    @Test
    void test01() {
        GameResult result = GameResult.createResult(LadderTest.L1, PlayersTest.PS1, RewardsTest.RS1, PlayerTest.P1);
        assertThat(result.getReward()).isEqualTo(RewardTest.R4);
    }
}
