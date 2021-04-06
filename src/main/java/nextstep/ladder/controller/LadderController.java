package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.view.InputView;

public class LadderController {

    public static void main(String[] args) {
        String[] userName = InputView.getUserName();
        int ladderHeight = InputView.getLadderHeight();

        LadderGame ladderGame = LadderGame.of(ladderHeight, userName);
    }
}
