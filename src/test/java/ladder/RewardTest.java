package ladder;

import ladder.domain.Reward;
import ladder.domain.Rewards;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    public void withWhiteSpaceReward() {
        //given
        String expectReward = "a       ";
        Reward reward = new Reward("a");

        //when
        String resultReward = reward.withWhiteSpaceReward();

        //then
        assertThat(resultReward).isEqualTo(expectReward);
    }

    @Test
    public void getAllRewardTest() {
        //given
        String expectEdge = "a       b       c       d       ";
        Rewards rewards = Rewards.valueOf(Arrays.asList("a", "b", "c", "d"));

        //when
        String resultEdge = rewards.getAllReward();

        //then
        assertThat(resultEdge).isEqualTo(expectEdge);
    }
}
