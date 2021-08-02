package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        int ladderHeight = InputView.inputLadderHeight();
    }

}
