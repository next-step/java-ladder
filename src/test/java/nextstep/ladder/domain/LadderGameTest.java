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
        Ladder ladder = new Ladder(lines, players);
        WinningItems winningItems = new WinningItems(players.numberOfPlayers(), "꽝", "1000", "2000");

        ladderGame = new LadderGame(ladder, winningItems);
    }

    @Test
    void 게임_실행_결과_테스트_한명() {

        LadderGameResult ladderGameResult = ladderGame.gameStart("kbc");

        String resultString = ladderGameResult.toString();

        assertThat(resultString).isEqualTo("2000");
    }

    @Test
    void 게임_실행_결과_테스트_전체() {

        LadderGameResult ladderGameResult = ladderGame.gameStart("all");

        String resultString = ladderGameResult.toString();

        assertThat(resultString).isEqualTo("kbc: 2000\nkbc1: 꽝\nkbc2: 1000");
    }
}
