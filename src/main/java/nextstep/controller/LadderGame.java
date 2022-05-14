package nextstep.controller;

import nextstep.domain.StartLadderGame;
import nextstep.view.InputView;
import nextstep.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        StartLadderGame startLadderGame = new StartLadderGame(InputView.inputUserName()
                , InputView.inputMaxLadderHeight());
        ResultView.print(startLadderGame);
    }
}
