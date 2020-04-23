package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {
    @Test
    void size() {
        String rewardNames = "ggang,lucky,lucky2";
        assertThat(LadderRewards.of(rewardNames, ",").size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:ggang", "1:lucky", "2:lucky2"}, delimiter = ':')
    void getUser(int position, String rewardName) {
        String rewardNames = "ggang,lucky,lucky2";
        LadderRewards ladderRewards = LadderRewards.of(rewardNames, ",");
        assertThat(ladderRewards.getReward(new Position(position))).isEqualTo(new LadderReward(rewardName));
    }
}
