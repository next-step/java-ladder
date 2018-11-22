package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ladder.view.ResultView;

public class LadderGameTest {

    @Test
    public void 게임진행() {
        Players players = Players.of("a,b,c");
        Results results = Results.of("꽝,1,2");
        GameLevel gameLevel = GameLevel.of("하");
        int height = 5;

        LadderGame ladderGame = new LadderGame(players, results);
        Ladder ladder = ladderGame.makeLadder(gameLevel.getLineHeight(), (count) -> { return createLine(); });

        LadderResult ladderResult = ladderGame.start(ladder);

        assertThat(ladder.getLines().size()).isEqualTo(5);
        assertThat(ladderResult.get(Player.of("a"))).isEqualTo(Result.of("꽝"));
        assertThat(ladderResult.get(Player.of("b"))).isEqualTo(Result.of("1"));
        assertThat(ladderResult.get(Player.of("c"))).isEqualTo(Result.of("2"));
    }

    private Line createLine() {
        Line line = new Line();
        line.addPoint(Point.of(false, false));
        line.addPoint(Point.of(false, false));
        line.addPoint(Point.of(false, false));
        return line;
    }
}