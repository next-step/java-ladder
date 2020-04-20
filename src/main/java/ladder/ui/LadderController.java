package ladder.ui;

import ladder.application.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.LadderGameInfo;
import ladder.domain.LadderGameResults;
import ladder.domain.LadderInfo;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private static final String TARGET_ALL = "all";

    public static void main(String[] args) {
        String users = InputView.inputNames();
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(users, InputView.inputRewards());
        LadderInfo ladderInfo = LadderInfo.of(users, InputView.inputHeight());

        Ladder ladder = LadderGame.createLadder(ladderInfo);
        LadderGameResults results = LadderGame.start(ladder, ladderGameInfo);

        ResultView.print(ladder, ladderGameInfo);
        String inputTarget = InputView.inputTarget();
        while (TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, results);
        }
    }
}
