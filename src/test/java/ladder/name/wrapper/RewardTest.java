package ladder.name.wrapper;

import ladder.model.move.Point;
import ladder.model.name.wrapper.Reward;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTest {
    @Test
    public void 정상_생성(){
        assertThat(Reward.of("a", Point.rewardPoint(1,2)).toString()).isEqualTo("a");
    }

    @Test
    public void match(){
        Reward reward = Reward.of("a", Point.rewardPoint(2,2));
        assertThat(reward.match(Point.rewardPoint(2,2))).isTrue();
        assertThat(reward.match(Point.rewardPoint(1,1))).isFalse();
    }
}
