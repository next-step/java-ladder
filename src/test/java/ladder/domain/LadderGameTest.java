package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import ladder.view.ResultView;

public class LadderGameTest {

    @Test
    public void 게임진행() {
        Players players = Players.of("a,b,c");
        Results results = Results.of("꽝,1,2");
        int height = 5;

        LadderGame ladderGame = new LadderGame(players, results);
        Ladder ladder = ladderGame.makeLadder(height, (count) -> { return createLine(); });

        LadderResult ladderResult = ladderGame.start(ladder);
        ResultView.printLadderResult(players, ladder, results);
        
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