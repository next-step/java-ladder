package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBoardTest {

    @DisplayName("특정 플레이어의 보상을 구한다.")
    @Test
    void test01() {
        GameBoard gameBoard = new GameBoard(PlayersTest.PS1, LadderTest.L1);
        GameResult gameResult = gameBoard.result(PlayerTest.P1, RewardsTest.RS1);
        assertThat(gameResult.getReward()).isEqualTo(RewardTest.R4);
    }
}
