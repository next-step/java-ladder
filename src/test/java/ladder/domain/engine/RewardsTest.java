package ladder.domain.engine;

import ladder.domain.impl.RewardsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {

    @DisplayName("사다리 타기의 결과목록을 확인할 수 있다.")
    @Test
    void getRewardsTest() {
        List<String> rewardList = List.of("꽝", "5000", "꽝", "3000");
        Rewards rewards = RewardsImpl.of(rewardList);

        List<String> rewards2 = rewards.getRewards();

        assertThat(rewards2).isEqualTo(rewardList);
    }


    @DisplayName("사다리 타기의 결과를 인덱스로 조회할 수 있다.")
    @Test
    void getTest() {
        List<String> rewardList = List.of("꽝", "5000", "꽝", "3000");
        Rewards rewards = RewardsImpl.of(rewardList);

        String reward1 = rewards.get(0);
        String reward2 = rewards.get(1);
        String reward3 = rewards.get(2);
        String reward4 = rewards.get(3);

        assertThat(reward1).isEqualTo(rewardList.get(0));
        assertThat(reward2).isEqualTo(rewardList.get(1));
        assertThat(reward3).isEqualTo(rewardList.get(2));
        assertThat(reward4).isEqualTo(rewardList.get(3));
    }
}