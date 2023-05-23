package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.UserNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public LadderGameController() {
    }

    public void playLadderGame() {
        String[] names = InputView.readUserNames();
        String[] results = InputView.readGameResult();
        LadderHeight ladderHeight = new LadderHeight(InputView.readLadderHeight());
        UserNames userNames = UserNames.of(names);

        LadderGame ladderGame = LadderGame.create(ladderHeight, userNames);

        ResultView.printMessage("실행결과");
        ResultView.printBlankLine();

        ResultView.printUserNames(userNames.userNames());
        ResultView.printLadder(ladderGame.toList());
    }


}
