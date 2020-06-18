package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private PlayersGroup playersGroup;
    private GamePrizesGroup gamePrizesGroup;
    private DrawingLineStrategy drawingLineStrategy;
    private Ladder ladder;
    private LadderGame ladderGame = new LadderGame();

    /*
    aa   bb   cc
    |----|    |
    |----|    |
    |----|    |
    꽝 1000 4444
    형태의 사다리로 테스트를 진행합니다.
    */
    @BeforeEach
    public void setupLadderGame() {
        playersGroup = PlayersGroup.of(Arrays.asList("aa", "bb", "cc"));
        gamePrizesGroup = GamePrizesGroup.of(Arrays.asList("꽝", "1000", "4444"), playersGroup);
        drawingLineStrategy = new DrawingLineStrategy() {
            @Override
            public List<Point> drawLine(int playerCounts) {
                List<Point> points = Arrays.asList(new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.DOWN));
                return points;
            }
        };
        ladder = Ladder.buildLadder(playersGroup, 3, drawingLineStrategy);
    }

    @DisplayName("첫 번째 참가자의 사다리 게임 결과를 확인")
    @Test
    public void playLadderGame_첫번째_참가자_결과() {
        GameResult result = ladderGame.play(playersGroup, ladder, gamePrizesGroup);

        assertThat(result.getGamePrizeNameByPlayerName("aa")).isEqualTo("1000");
    }

    @DisplayName("두 번째 참가자의 사다리 게임 결과를 확인")
    @Test
    public void playLadderGame_두번째_참가자_결과() {
        GameResult result = ladderGame.play(playersGroup, ladder, gamePrizesGroup);

        assertThat(result.getGamePrizeNameByPlayerName("bb")).isEqualTo("꽝");
    }

    @DisplayName("세 번째 참가자의 사다리 게임 결과를 확인")
    @Test
    public void playLadderGame_세번째_참가자_결과() {
        GameResult result = ladderGame.play(playersGroup, ladder, gamePrizesGroup);

        assertThat(result.getGamePrizeNameByPlayerName("cc")).isEqualTo("4444");
    }
}

