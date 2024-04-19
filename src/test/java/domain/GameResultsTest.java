package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {

    private static final GameResults GRS1 = GameResults.createResults(LadderTest.L1, PlayersTest.PS1, RewardsTest.RS1);

    @DisplayName("전체 결과를 생성한다.")
    @Test
    void test01() {
        assertThat(GRS1).isNotNull();
    }

    @DisplayName("특정 플레이어의 결과를 가져온다.")
    @Test
    void test02() {
        GameResults results = GameResults.createResults(LadderTest.L1, PlayersTest.PS1, RewardsTest.RS1);
        GRS1.resultByPlayer(PlayerTest.P1).isEqualTo(RewardTest.R2);
    }
}
