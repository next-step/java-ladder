package nextstep.laddergame;

import nextstep.laddergame.domain.DrawBridgeStrategy;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.ResultView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {
        List<String> gamerNames = InputView.inputGamerNames();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(gamerNames, ladderHeight, DrawBridgeStrategy.DEFAULT_STRATEGY);

        ResultView.printLadder(ladder);
    }
}
