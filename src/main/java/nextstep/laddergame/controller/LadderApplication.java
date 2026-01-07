package nextstep.laddergame.controller;

import nextstep.laddergame.domain.LadderGame;
import nextstep.laddergame.view.InputView;
import nextstep.laddergame.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        String participantsName = InputView.inputParticipantsName();
        String ladderHeight = InputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(participantsName, ladderHeight);
        OutputView.printLadderResult(ladderGame);
    }
}