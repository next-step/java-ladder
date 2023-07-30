package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void init() {
        Players players = new Players("kbc", "kbc1", "kbc2");
        List<Line> lines = List.of(
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(true), new Point(false))),
                new Line(players.numberOfPlayers(), c -> List.of(new Point(false), new Point(false), new Point(true)))
        );
        Ladder ladder = new Ladder(lines, players.numberOfPlayers());

        ladderGame = new LadderGame(ladder);
    }

    @Test
    void 게임_실행_결과_테스트_한명() {

        MoveResult moveResult = ladderGame.gameStart(0);

        assertThat(moveResult.getWinningItemIndex(0)).isEqualTo(2);
    }

    @Test
    void 게임_실행_결과_테스트_전체() {
        MoveResult moveResult = ladderGame.gameStart();

        assertThat(moveResult.getWinningItemIndex(0)).isEqualTo(2);
        assertThat(moveResult.getWinningItemIndex(1)).isEqualTo(0);
        assertThat(moveResult.getWinningItemIndex(2)).isEqualTo(1);
    }
}
