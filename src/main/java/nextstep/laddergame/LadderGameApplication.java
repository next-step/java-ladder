package nextstep.laddergame;

import nextstep.laddergame.domain.DrawBridgeStrategy;
import nextstep.laddergame.domain.Game;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;
import nextstep.laddergame.wrapper.Height;
import nextstep.laddergame.wrapper.Participants;
import nextstep.laddergame.wrapper.RewardWrapper;

public class LadderGameApplication {
    public static void main(String[] args) {
        // Parameter Sample
        // pobi,honux,crong,jk
        // 꽝,5000,꽝,3000
        // 5

        Participants participants = InputView.inputGamerNames();
        RewardWrapper rewardWrapper = InputView.inputRewards();
        Height ladderHeight = InputView.inputLadderHeight();

        Game game = new Game(participants, ladderHeight, DrawBridgeStrategy.DEFAULT_STRATEGY);

        ResultView.printResult(game, rewardWrapper);
    }
}
