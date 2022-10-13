package nextstep.laddergame;

import nextstep.laddergame.domain.DrawBridgeStrategy;
import nextstep.laddergame.domain.Game;
import nextstep.laddergame.domain.Gamer;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;
import nextstep.laddergame.wrapper.Height;
import nextstep.laddergame.wrapper.RewardWrapper;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        // Parameter Sample
        // pobi,honux,crong,jk
        // 꽝,5000,꽝,3000
        // 5

        List<Gamer> gamers = InputView.inputGamerNames();
        RewardWrapper rewardWrapper = InputView.inputRewards();
        Height ladderHeight = InputView.inputLadderHeight();

        Game game = new Game(gamers, ladderHeight, DrawBridgeStrategy.DEFAULT_STRATEGY);

        ResultView.printResult(game, rewardWrapper);
    }
}
