package ladder.reward;

import ladder.domain.gamer.Gamers;
import ladder.domain.reward.Rewards;
import ladder.domain.reward.info.Reward;
import ladder.domain.reward.message.ErrorMessages;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RewardsTest {
    private Rewards rewards;
    private Gamers gamers;
    
    @BeforeEach
    void setUp() {
        rewards = Rewards.newInstance();
        gamers = Gamers.newInstance();
    }
    
    @Test
    @DisplayName("[fail] 쉼표(,) 로 구분된 보상정보가 입력되어야 하는 보상정보 갯수와 일치하지 않으면 exception")
    void matchParamsTest() {
        //Given
        String result = "꽝,5000,꽝,5000";
        gamers.addGamers("aa,bb,cc,dd,ee");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> rewards.setRewards(gamers, result))
          .withMessage(ErrorMessages.NOT_MATCH_COUNT.message());
    }
    
    @Test
    @DisplayName("[success] reward 목록을 정상적으로 가져온다.")
    void getGamerNamesTest() {
        //Given
        List<String> givenRewardNames = Arrays.asList("꽝", "5000", "1000");
        gamers.addGamers("aa,bb,cc");
        rewards.setRewards(gamers, "꽝,5000,1000");
        
        //When
        List<String> resultRewardNames = rewards.getRewardNames();
        
        //Then
        Assertions.assertThat(givenRewardNames.containsAll(resultRewardNames)).isTrue();
    }
    
    @Test
    @DisplayName("[success] 보상 번호로 실제 보상을 가져온다.")
    void getGameRewardTest() {
        //Given
        gamers.addGamers("aa,bb,cc");
        rewards.setRewards(gamers, "꽝,5000,1000");
        
        //When
        Reward reward = rewards.getReward(0);
        
        //Then
        Assertions.assertThat(reward.getReward()).isEqualTo("꽝");
    }
    
    @Test
    @DisplayName("[fail] 보상 번호가 보상 목록의 총 갯수를 넘어갈 수 없다.")
    void getGameRewardFailTest() {
        //Given
        gamers.addGamers("aa,bb,cc");
        rewards.setRewards(gamers, "꽝,5000,1000");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> rewards.getReward(4))
            .withMessage(ErrorMessages.OVER_INPUT_REWARD.message());
    }
    
    @Test
    @DisplayName("[success] 리워드 정보가 하나라도 있으면 false")
    void isRewardsNeededFalseTest() {
        //Given
        Gamers gamers = Gamers.newInstance();
        gamers.addGamers("a");
        Rewards rewards = Rewards.newInstance();
        rewards.setRewards(gamers, "1");
        
        //When
        boolean rewardNeeded = rewards.isRewardsNeeded();
        
        //Then
        Assertions.assertThat(rewardNeeded).isFalse();
    }
    
    @Test
    @DisplayName("[success] 리워드 정보가 하나도 없으면 true")
    void isRewardsNeededTrueTest() {
        //Given
        Rewards rewards = Rewards.newInstance();
        
        //When
        boolean rewardNeeded = rewards.isRewardsNeeded();
        
        //Then
        Assertions.assertThat(rewardNeeded).isTrue();
    }
}
