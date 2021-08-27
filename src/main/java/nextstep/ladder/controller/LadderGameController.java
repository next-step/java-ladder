package nextstep.ladder.controller;

import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    public static void play() {
        InputView inputView = InputView.getInstance();

        Players players = new Players(inputView.askPlayerNames());
        int ladderHeight = inputView.askLadderHeight();
        inputView.closeInputScanner();

        ResultView outputView = ResultView.getInstance();


    }

}
