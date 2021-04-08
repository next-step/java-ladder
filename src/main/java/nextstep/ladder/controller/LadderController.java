package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        List<String> userName = InputView.getUserName();
        int ladderHeight = InputView.getLadderHeight();

        LadderGame ladderGame = LadderGame.of(ladderHeight, userName);
        ResultView.printLadder(ladderGame.getParticipants(), ladderGame.getLines());
    }
}
