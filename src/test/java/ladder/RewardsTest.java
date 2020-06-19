package ladder;

import ladder.domain.Reward;
import ladder.domain.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    @DisplayName("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)")
    @Test
    void getResultCountTest() {
        String reulstsString = "꽝,꽝,5000원,5000";
        Rewards rewards = new Rewards(reulstsString);
        Reward reward = new Reward("꽝", 0);

        assertThat(rewards.getResultCount()).isEqualTo(4);
        assertThat(rewards.getResult(reward)).isEqualTo(reward);

    }

    @DisplayName("ladderResult 객체 테스트")
    @Test
    void getResultByPositionIndexTest() {
        String reulstsString = "1000";
        Rewards rewards = new Rewards(reulstsString);
        Reward reward = new Reward("1000", 0);

        assertThat(rewards.getResultByPositionIndex(0)).isEqualTo(reward);
    }

}
