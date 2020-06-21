package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGamePlay;
import nextstep.ladder.view.LadderGameView;

import java.util.List;

public class LadderGame {

    public void playLadderGame() {
        List<String> userNames = LadderGameView.inputUserNames();
        List<String> executionResult = LadderGameView.inputExecutionResults();
        Integer ladderHeight = LadderGameView.inputLadderHeight();
        Ladder ladder = Ladder.of(userNames, executionResult, ladderHeight);
        LadderGameView.viewLadderShape(ladder);

        LadderGamePlay ladderGamePlay = LadderGamePlay.of(ladder);
        ladderGamePlay.playLadderGame(ladder.getPlayers().getPlayers().get(1));
    }
}
