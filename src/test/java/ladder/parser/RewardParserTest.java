package ladder.parser;

import ladder.domain.reward.Rewards;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardParserTest {
    @Test
    public void 문자열을_Rewards_객체로_변환() {
        // given
        String rewardsString = "mac, 꽝, xbox, ps4";

        // when
        Rewards rewards = RewardParser.parseRewards(rewardsString);

        // then
        assertThat(rewards.getNumberOfRewards()).isEqualTo(4);
    }
}
