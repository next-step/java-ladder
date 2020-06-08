package nextstep.ladder.ui;

import nextstep.ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsOutputViewTests {
    @DisplayName("글자 길이에 따라 알맞는 공백이 입력된 Rewards를 출력할 수 있다.")
    @Test
    void parseRewardsTest() {
        RewardsOutputView rewardsOutputView = new RewardsOutputView(Rewards.create("1, 2, 3"));

        assertThat(rewardsOutputView.parseRewards(5)).isEqualTo("     1     2     3"
                + System.lineSeparator());
    }
}
