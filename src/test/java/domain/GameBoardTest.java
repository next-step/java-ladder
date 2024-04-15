package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBoardTest {

    @DisplayName("특정 플레이어에 대한 결과를 확인한다.")
    @Test
    void test01() {
        int height = 3;
        Line line1 = Line.createWithBridges(height, () -> true);
        Line line2 = Line.createWithBridges(height, () -> false);
        Line line3 = Line.createWithBridges(height, () -> false);
        Lines lines = Lines.from(List.of(line1, line2, line3));
        GameBoard gameBoard = new GameBoard(lines, PlayersTest.PS1);
        Rewards rewards = new Rewards(List.of(new Reward("꽝"), new Reward("2000"), new Reward("3000")));
        Reward reward = gameBoard.getReward(PlayerTest.P1, rewards);

        assertThat(reward).isEqualTo(new Reward("2000"));
    }

    @DisplayName("특정 플레이어의 보상을 구한다.")
    @Test
    void test02() {
        Bridge first = Bridge.first(true);
        Bridge second = first.next(false);
        Bridge third = second.next(true);
        Bridge fourth = second.next(false);
        Bridges firstHeightBridges = new Bridges(List.of(first, second, third, fourth));

        Bridge first1 = Bridge.first(false);
        Bridge second1 = first1.next(true);
        Bridge third1 = second1.next(false);
        Bridge fourth1 = second.next(true);
        Bridges secondHeightBridges = new Bridges(List.of(first1, second1, third1, fourth1));

        Bridge first2 = Bridge.first(true);
        Bridge second2 = first2.next(false);
        Bridge third2 = second2.next(true);
        Bridge fourth2 = second.next(false);
        Bridges thirdHeightBridges = new Bridges(List.of(first2, second2, third2, fourth2));
        Ladder ladder = new Ladder(List.of(firstHeightBridges, secondHeightBridges, thirdHeightBridges));
        GameBoard gameBoard = new GameBoard(PlayersTest.PS1, ladder);
        Reward reward = gameBoard.result1(PlayerTest.P1, RewardsTest.RS1);
        assertThat(reward).isEqualTo(RewardTest.R4);
    }
}
