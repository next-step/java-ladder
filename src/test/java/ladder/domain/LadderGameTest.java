package ladder.domain;

import ladder.view.ResultView;
import org.junit.Test;

public class LadderGameTest {

    @Test
    public void 게임진행() {
        Players players = Players.of("a,b,c");
        Results results = Results.of("꽝,1,2");
        int height = 5;

        LadderGame ladderGame = new LadderGame(players, results);
        Ladder ladder = ladderGame.makeLadder(height);

        LadderResult ladderResult = ladderGame.start();
        ResultView.printResult(players, ladder, results);
        System.out.println("a " + ladderResult.get(Player.of("a")).getName());
        System.out.println("b " + ladderResult.get(Player.of("b")).getName());
        System.out.println("c " + ladderResult.get(Player.of("c")).getName());
    }
}