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
        List<Reward> rewards = List.of(new Reward("꽝"), new Reward("2000"), new Reward("3000"));
        Reward reward = gameBoard.getReward(PlayerTest.P1, rewards);

        assertThat(reward).isEqualTo(new Reward("2000"));
    }
}
