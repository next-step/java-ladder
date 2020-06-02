package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTests {
    @DisplayName("RewardValue를 인자로 받아서 String collection으로 파싱할 수 있다.")
    @Test
    void parseRewardValueTest() {
        String rewardValue = "empty, 1000, empty";
        assertThat(Rewards.parseRewardValues(rewardValue).get(0)).isEqualTo("empty");
    }
}
