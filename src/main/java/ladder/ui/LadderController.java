package ladder.ui;

import ladder.application.LadderGame;
import ladder.domain.*;
import ladder.dto.LadderRequest;
import ladder.infra.RandomDirection;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private static final String TARGET_ALL = "all";
    private static final String SEPARATOR = ",";

    public static void main(String[] args) {
        LadderRequest ladderRequest = InputView.inputLadderInfo();
        Users users = Users.of(ladderRequest.getUserNames(), SEPARATOR);
        LadderRewards ladderRewards = LadderRewards.of(ladderRequest.getRewards(), SEPARATOR);
        LadderGameInfo ladderGameInfo = new LadderGameInfo(users, ladderRewards);

        DirectionCreator directionCreator = new RandomDirection();
        Ladder ladder = Ladder.of(users.size(), directionCreator, ladderRequest.getHeight());
        LadderGame ladderGame = new LadderGame(ladder, ladderGameInfo);
        LadderGameResults results = ladderGame.start();

        ResultView.print(ladder, ladderGameInfo);
        String inputTarget = InputView.inputTarget();
        while (TARGET_ALL.equals(inputTarget)) {
            inputTarget = InputView.inputTarget();
            ResultView.printResult(inputTarget, results);
        }
    }
}
