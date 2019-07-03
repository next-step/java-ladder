package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LadderRewardTypeTest {

    @DisplayName("랜덤으로 뽑한 LadderRewardType 은 반드시, LadderRewardType 사이의 값이여야 합니다.")
    @ParameterizedTest
    @ValueSource(ints={1, 2, 3, 4, 5})
    public void testRandomRewardType() {
        LadderRewardType rewardType = LadderRewardType.getRandomType();
        assertThat(LadderRewardType.values()).contains(rewardType);
    }
}
