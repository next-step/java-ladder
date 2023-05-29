package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.ResultMap;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public LadderGameController() {
    }

    public void playLadderGame() {
        UserNames userNames = UserNames.of(InputView.readUserNames());
        String[] results = InputView.readGameResult();
        LadderHeight ladderHeight = new LadderHeight(InputView.readLadderHeight());

        Lines ladder = new Lines(ladderHeight, userNames.count());
        ResultMap result = ladder.getResult(userNames, results);

        printLadder(userNames, results, ladder);
        ResultView.printResult(userNames.userNames(), result);
    }

    private void printLadder(UserNames userNames, String[] results, Lines ladder) {
        ResultView.printMessage("실행결과");
        ResultView.printBlankLine();
        ResultView.printLadder(userNames.userNames(), ladder, results);
    }


}
