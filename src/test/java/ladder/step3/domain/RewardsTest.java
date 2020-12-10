package ladder.step3.domain;

import ladder.domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Reward;
import step3.domain.Rewards;
import step3.utils.SpliterUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardsTest {

    @ParameterizedTest
    @DisplayName("입력받은 리워드 정상 입력 후 리스트에 담겼는지 확인")
    @ValueSource(strings = {"1000,꽝,1등,2등"})
    public void 입력받은_리워드_정상노출_확인(String rewardName) {
        Rewards reward = Rewards.of(SpliterUtil.splitNames(rewardName));
        assertThat(reward.getRewards().size()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("입력받은 리워드 빈값인 경우 예외")
    @EmptySource
    public void 입력받은_리워드_빈값인경(String rewardName) {
        assertThatThrownBy(() -> Reward.of(rewardName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("제공 될 보상을 입력해주세요.");
    }

}
