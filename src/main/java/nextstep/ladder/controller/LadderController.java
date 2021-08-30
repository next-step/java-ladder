package nextstep.ladder.controller;

import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderController {
    public void startLadderGame() {
        List<String> players = InputView.inputPlayers();
        int ladderCount = InputView.inputLadderCount();
    }
}
