package nextstep.ladder2.reward;

import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {

    @Test
    void 빈_리스트로_생성할수없다() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Rewards(new ArrayList<>())
        );
    }
    
    @Test
    void 보상_리스트_생성() {
        Rewards rewards = new Rewards("꽝", "당첨");
        
        assertThat(rewards.count()).isEqualTo(2);
        assertThat(rewards.get(0)).isEqualTo(new Reward("꽝"));
        assertThat(rewards.get(1)).isEqualTo(new Reward("당첨"));
    }
}