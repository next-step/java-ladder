package ladder.ui;

import ladder.application.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.LadderGameInfo;
import ladder.domain.LadderGameResults;
import ladder.domain.LadderInfo;
import ladder.dto.LadderInfoRequest;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private static final String TARGET_ALL = "all";

    public static void main(String[] args) {
        LadderInfoRequest ladderInfoRequest = InputView.inputLadderInfo();
        String users = ladderInfoRequest.getUserNames();
        LadderGameInfo ladderGameInfo = LadderGameInfo.of(users, ladderInfoRequest.getRewards());
        LadderInfo ladderInfo = LadderInfo.of(users, ladderInfoRequest.getHeight());

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
