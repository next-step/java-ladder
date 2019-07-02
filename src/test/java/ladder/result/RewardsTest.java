package ladder.result;

import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RewardsTest {
    @Test
    @DisplayName("[fail] 쉼표(,) 로 구분된 보상정보가 입력되어야 하는 보상정보 갯수와 일치하지 않으면 exception")
    void matchParamsTest() {
        //Given
        String result = "꽝,5000,꽝,5000";
        int maxResultCount = 5;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Rewards.of(maxResultCount, result))
          .withMessage(ErrorMessages.NOT_MATCH_COUNT.message());
    }
    
    @Test
    @DisplayName("[fail] 보상 갯수정보에 0을 입력할 수 없다.")
    void cantInputZeroTest() {
        //Given
        String result = "";
        int maxResultCount = 0;
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> Rewards.of(maxResultCount, result))
          .withMessage(ErrorMessages.CANT_INPUT_ZERO.message());
    }
    
    @Test
    @DisplayName("[success] 생성시 입력된 reward 목록을 정상적으로 가져온다.")
    void getGamerNamesTest() {
        //Given
        List<String> givenRewardNames = Arrays.asList("꽝", "5000", "1000");
        Rewards rewards = Rewards.of(3, "꽝,5000,1000");
        
        //When
        List<String> resultRewardNames = rewards.getRewardNames();
        
        //Then
        Assertions.assertThat(givenRewardNames.containsAll(resultRewardNames)).isTrue();
    }
}
