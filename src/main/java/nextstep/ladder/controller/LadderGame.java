package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.LadderGameView;

import java.util.List;

public class LadderGame {

    public void playLadderGame() {
        List<String> userNames = LadderGameView.inputUserNames();
        List<String> executionResult = LadderGameView.inputExecutionResults();
        Integer ladderHeight = LadderGameView.inputLadderHeight();
        Ladder ladder = Ladder.of(userNames, ladderHeight);
        LadderGameView.viewLadderShape(ladder);
    }
}
