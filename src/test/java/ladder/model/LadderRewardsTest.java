package ladder.model;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class LadderRewardsTest {

    @Test
    public void 사다리_결과_랭킹_매핑_검증() {
        LadderRewards sample = LadderRewards.of(Arrays.array("1000", "꽝", "1000", "꽝"));

        LadderRewards result = sample.getRewardsByRank(newArrayList(0, 2, 3, 1));

        LadderRewards expected = LadderRewards.of(Arrays.array("1000", "1000", "꽝", "꽝"));

        assertThat(result).isEqualTo(expected);
    }
}