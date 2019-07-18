package domain;

import ladder.domain.LadderRewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderRewardsTest {

    @DisplayName("입력한 결과 문자열 만큼 크기가 정해져야 합니다.")
    @Test
    public void testCountOfPersonSameListSize() {
        String resultsString = "꽝, 1000, 5000, 10000";
        LadderRewards ladderRewards = LadderRewards.of(resultsString);

        int actualSize = resultsString.split(",").length;
        assertThat(ladderRewards.size()).isEqualTo(actualSize);
    }
}
