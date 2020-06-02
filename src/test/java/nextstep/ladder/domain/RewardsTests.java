package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.InvalidRewardsParameterException;
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
        assertThat(Rewards.parseRewardValues(rewardValues).get(0)).isEqualTo("empty");
    }

    @DisplayName("RewardValue, Players를 인자로 전달 받아서 일급 컬렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        Players players = Players.create("poppo, sual, ita");
        String rewardValues = "empty, 1000, empty";

        Rewards rewards = Rewards.create(players, rewardValues);

        assertThat(rewards).isNotNull();
        assertThat(rewards.size()).isEqualTo(3);
    }

    @DisplayName("파싱된 RewardValue와 Players의 수가 다르면 예외 발생")
    @Test
    void createValidationTest() {
        Players players = Players.create("poppo, sual");
        String rewardValues = "empty, 1000, empty";

        assertThatThrownBy(() -> Rewards.create(players, rewardValues))
                .isInstanceOf(InvalidRewardsParameterException.class);
    }

    @DisplayName("RewardValue가 비어있거나 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = { " ", "" })
    void rewardValueValidationTest(String invalidRewardValue) {
        Players players = Players.create("poppo, sual");

        assertThatThrownBy(() -> Rewards.create(players, invalidRewardValue))
                .isInstanceOf(InvalidRewardsParameterException.class);
    }
}
