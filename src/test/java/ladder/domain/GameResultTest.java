package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameResultTest {
    @Test
    public void construct(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameResult("100,0,200,500",3))
                .withMessage("실행 결과의 입력값이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
    }

    @Test
    public void matchUserWithReward(){
        UserGroup userGroup = new UserGroup("a,b,c,d");
        GameResult gameResult = new GameResult("100,0,200,500",4);

        gameResult.getResult(userGroup.getUserGroup());
        assertThat(gameResult.getGameReward().get(0).getNameOfWinner()).isEqualTo(userGroup.getUserGroup().get(0).getName());
    }
}