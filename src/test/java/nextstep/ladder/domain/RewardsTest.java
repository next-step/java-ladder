package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardsTest {

    @DisplayName("해당 위치의 결과를 반환한다")
    @Test
    void getRewardByPositionTest() {
        List<String> rewardList = Arrays.asList("1", "2", "3");
        Rewards rewards = Rewards.from(rewardList);
        assertThat(rewards.positionOfReward(0)).isEqualTo(new Reward("1"));
    }

}
