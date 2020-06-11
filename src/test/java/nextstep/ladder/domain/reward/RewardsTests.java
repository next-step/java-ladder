package nextstep.ladder.domain.reward;

import nextstep.ladder.domain.exceptions.InvalidRewardsParameterException;
import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardsTests {
    @DisplayName("RewardValue를 인자로 받아서 String collection으로 파싱할 수 있다.")
    @Test
    void parseRewardValueTest() {
        String rewardValues = "empty, 1000, empty";
        assertThat(Rewards.parseRewardValues(rewardValues).get(0)).isEqualTo(new Reward("empty"));
    }

    @DisplayName("RewardValue를 인자로 전달 받아서 일급 컬렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        String rewardValues = "empty, 1000, empty";

        Rewards rewards = Rewards.create(rewardValues);

        assertThat(rewards).isNotNull();
        assertThat(rewards.size()).isEqualTo(3);
    }

    @DisplayName("RewardValue가 비어있거나 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { " ", "" })
    void rewardValueValidationTest(String invalidRewardValue) {
        assertThatThrownBy(() -> Rewards.create(invalidRewardValue))
                .isInstanceOf(InvalidRewardsParameterException.class);
    }
}
