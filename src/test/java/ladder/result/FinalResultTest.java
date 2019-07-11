package ladder.result;

import ladder.domain.gamer.Gamers;
import ladder.domain.ladder.LadderModel;
import ladder.domain.result.FinalResult;
import ladder.domain.reward.Rewards;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FinalResultTest {
    @Test
    @DisplayName("[success] Gamers 와 LadderModel 와 Rewards 를 받아 결과를 저장할 때 입력된 갯수와 일치하는 결과값이 생성됨.")
    void setFinalRewardsTest() {
        //Given
        Gamers gamers =  Gamers.newInstance();
        gamers.addGamers("a,b");
        Rewards rewards = Rewards.newInstance();
        rewards.setRewards(gamers, "1,2");
        LadderModel ladderModel = LadderModel.newInstance();
        ladderModel.makeLadder(5, gamers);
        FinalResult result = FinalResult.newInstance();
        
        //When
        result.goToGoal(gamers, ladderModel, rewards);
        
        //Then
        Assertions.assertThat(result.getSize()).isEqualTo(2);
    }
}
