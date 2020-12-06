package ladder.group;

import ladder.model.group.Rewards;
import ladder.model.move.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class RewardsTest {
    @Test
    public void 정상_Rewards_생성(){
        assertThat(Rewards.from("a,b,c",3).getNames()).containsExactly("a","b","c");
    }

    @Test
    public void 정상_reward_반환(){
        Rewards rewards = Rewards.from("a,b,c",3);
        assertThat(rewards.getReward(Point.rewardPoint(0,3))).isEqualTo("a");
        assertThat(rewards.getReward(Point.rewardPoint(1,3))).isEqualTo("b");
        assertThat(rewards.getReward(Point.rewardPoint(2,3))).isEqualTo("c");
    }

    @Test
    public void 비정상_reward_반환(){
        Rewards rewards = Rewards.from("a,b",2);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> rewards.getReward(Point.rewardPoint(2,3)))
                .withMessageMatching("해당 위치에 대한 결과가 없습니다.");
    }
}
