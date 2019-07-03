package ladder.gamer;

import ladder.domain.gamer.Gamers;
import ladder.domain.gamer.message.ErrorMessages;
import ladder.domain.ladder.Ladder;
import ladder.domain.reward.Rewards;
import ladder.domain.reward.info.Reward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GamersTest {
    private Gamers gamers;

    @BeforeEach
    void setUp() {
        //Given
        gamers = Gamers.of("one,two,three");
        
    }
    
    @Test
    @DisplayName("[success] 콤마(,) 로 구분된 문자열을 받아 정상적으로 Gamers를 생성한다.")
    void newGamersTest() {
        //Then
        Assertions.assertThat(gamers.getSize()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("[success] 생성시 입력된 이름의 목록을 정상적으로 가져온다.")
    void getGamerNamesTest() {
        //Given
        List<String> givenGamerNames = Arrays.asList("one", "two", "three");

        //When
        List<String> resultGamerNames = gamers.getGamerNames();
        
        //Then
        Assertions.assertThat(givenGamerNames.containsAll(resultGamerNames)).isTrue();
    }
    
    @Test
    @DisplayName("[fail] Ladder 와 Reward 를 받아 Reward 를 찾는다 - Ladder 가 없거나 라인 갯수가 안맞으면 exception")
    void findRewardNullLadderTest() {
        //Given
        Ladder nullLadder = null;
        Ladder notMatchLadder = Ladder.from(5, 5);
        Reward reward = Reward.from("꽝,5000,꽝");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.findReward(nullLadder, reward))
            .withMessage(ErrorMessages.NOT_MATCH_LADDER.message());
    
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.findReward(notMatchLadder, reward))
            .withMessage(ErrorMessages.NOT_MATCH_LADDER.message());
    }
    
    @Test
    @DisplayName("[fail] Ladder 와 Reward 를 받아 Reward 를 찾는다 - Reward 가 없거나 유저와 갯수가 안맞으면 exception")
    void findRewardNullRewardTest() {
        //Given
        Ladder ladder = Ladder.from(3, 3);
        Rewards nullReward = null;
        Rewards notMatchReward = Rewards.of(3, "꽝");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.findReward(ladder, nullReward))
            .withMessage(ErrorMessages.NOT_MATCH_REWARD.message());
    
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> gamers.findReward(ladder, notMatchReward))
            .withMessage(ErrorMessages.NOT_MATCH_REWARD.message());
    }
}
