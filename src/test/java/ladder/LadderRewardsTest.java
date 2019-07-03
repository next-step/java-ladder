package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderRewardsTest {

    @DisplayName("입력한 사람 수 만큼 LadderRewardType 리스트 크기가 정해져야 합니다.")
    @Test
    public void testCountOfPersonSameListSize() {
        int countOfPerson = 5;
        LadderRewards ladderRewards = LadderRewards.of(countOfPerson);
        List<LadderRewardType> ladderRewardTypes = ladderRewards.getLadderRewardTypes();
        assertThat(ladderRewardTypes).hasSize(countOfPerson);
    }
}
