package nextstep.ladder.domain.ladderGame;

import nextstep.ladder.domain.ladder.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRewardsTest {
    @Test
    @DisplayName("create & size 체크")
    void size() {
        String rewardNames = "ggang,lucky,lucky2";
        String separator = ",";
        assertThat(LadderRewards.of(rewardNames, separator).size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:ggang", "1:lucky", "2:lucky2"}, delimiter = ':')
    @DisplayName("Location 에 맞는 reward 가져오기")
    void getReward(int location, String rewardName) {
        String rewardNames = "ggang,lucky,lucky2";
        LadderRewards ladderRewards = LadderRewards.of(rewardNames, ",");
        assertThat(ladderRewards.getReward(Location.from(location))).isEqualTo(LadderReward.from(rewardName));
    }
}
