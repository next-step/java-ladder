package ladder.result;

import ladder.domain.reward.Rewards;
import ladder.domain.reward.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {
    @Test
    @DisplayName("[fail] 쉼표(,) 로 구분된 보상정보가 입력되어야 하는 보상정보 갯수와 일치하지 않으면 exception")
    void test() {
        //Given
        String result = "꽝,5000,꽝,5000";
        int maxResultCount = 5;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Rewards.of(maxResultCount, result))
          .withMessage(ErrorMessages.NOT_MATCH_COUNT.message());
    }
}
