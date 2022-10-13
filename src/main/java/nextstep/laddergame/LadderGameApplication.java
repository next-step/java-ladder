package nextstep.laddergame;

import nextstep.laddergame.domain.DrawBridgeStrategy;
import nextstep.laddergame.domain.Game;
import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.domain.Height;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        // Parameter Sample
        // pobi,honux,crong,jk
        // 5

        List<Gamer> gamers = InputView.inputGamerNames();
        Height ladderHeight = InputView.inputLadderHeight();

        Game game = new Game(gamers, ladderHeight, DrawBridgeStrategy.DEFAULT_STRATEGY);

        ResultView.printLadder(game);
    }
}
