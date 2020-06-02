package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
