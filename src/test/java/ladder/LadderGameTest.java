package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    /*
    aa   bb   cc
    |----|    |
    |----|    |
    |----|    |
    꽝 1000 4444
    형태의 사다리 테스트
    */
    @DisplayName("사다리 게임을 통해 각 플레이어들의 결과를 집계함")
    @Test
    public void playLadderGame() {
        PlayersGroup playersGroup = PlayersGroup.of(Arrays.asList("aa", "bb", "cc"));
        GamePrizesGroup gamePrizesGroup = GamePrizesGroup.of(Arrays.asList("꽝", "1000", "4444"), playersGroup);
        DrawingLineStrategy drawingLineStrategy = new DrawingLineStrategy() {
            @Override
            public List<Point> drawLine(int playerCounts) {
                List<Point> points = Arrays.asList(new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.DOWN));
                return points;
            }
        };
        Ladder ladder = Ladder.buildLadder(playersGroup, 3, drawingLineStrategy);

        LadderGame ladderGame = new LadderGame();
        GameResult result = ladderGame.play(playersGroup, ladder, gamePrizesGroup);

        assertThat(result.getResultByPlayerName("aa")).isEqualTo("1000");

        assertThat(result.getResultByPlayerName("bb")).isEqualTo("꽝");

        assertThat(result.getResultByPlayerName("cc")).isEqualTo("4444");
    }
}
