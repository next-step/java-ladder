package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBoardTest {

    @DisplayName("특정 플레이어의 보상을 구한다.")
    @Test
    void test01() {
        Bridge first = Bridge.firstOf(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridge fourth = second.next(false);
        Bridges firstHeightBridges = new Bridges(List.of(first, second, third, fourth));

        Bridge first1 = Bridge.firstOf(false);
        Bridge second1 = first1.next(true);
        Bridge third1 = second1.next(false);
        Bridge fourth1 = second.next(false);
        Bridges secondHeightBridges = new Bridges(List.of(first1, second1, third1, fourth1));

        Bridge first2 = Bridge.firstOf(true);
        Bridge second2 = first2.next(false);
        Bridge third2 = second2.next(true);
        Bridge fourth2 = second.next(false);
        Bridges thirdHeightBridges = new Bridges(List.of(first2, second2, third2, fourth2));
        Ladder ladder = new Ladder(List.of(firstHeightBridges, secondHeightBridges, thirdHeightBridges));
        GameBoard gameBoard = new GameBoard(PlayersTest.PS1, ladder);
        GameResult gameResult = gameBoard.result(PlayerTest.P1, RewardsTest.RS1);
        assertThat(gameResult.getReward()).isEqualTo(RewardTest.R4);
    }
}
