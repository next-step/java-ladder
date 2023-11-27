package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {

    @Test
    @DisplayName("보상은 2개 이상이어야 한다.")
    void rewardsInput(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Rewards(List.of("10000"));
        });
    }

    @Test
    @DisplayName("보상은 보상목록을 반환할 수 있다.")
    void rewardsReturn(){
        Rewards rewards = new Rewards(List.of("10000", "20000"));
        assertThat(rewards.rewards()).containsExactly("10000", "20000");
    }

}
