package ladder.group;

import ladder.model.group.Rewards;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {
    @Test
    public void 정상_Rewards_생성(){
        assertThat(Rewards.from("a,b,c").getNames()).containsExactly("a","b","c");
    }

    @Test
    public void 정상_reward_반환(){
        Rewards rewards = Rewards.from("a,b,c");
        assertThat(rewards.getReward(0)).isEqualTo("a");
        assertThat(rewards.getReward(1)).isEqualTo("b");
        assertThat(rewards.getReward(2)).isEqualTo("c");
    }

    @Test
    public void 비정상_reward_반환(){
        Rewards rewards = Rewards.from("a,b");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> rewards.getReward(2))
                .withMessageMatching("해당 위치에 대한 결과가 없습니다.");
    }
}
