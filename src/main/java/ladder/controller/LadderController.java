package ladder.controller;

import ladder.domain.Bridge;
import ladder.domain.RandomConnectionStrategy;
import ladder.service.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        String[] participantNames = InputView.inputParticipantNames();
        int participantCount = participantNames.length;
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        LadderGame ladderGame = new LadderGame();
        List<Bridge> ladder = ladderGame.createLadder(maxLadderHeight, participantCount, new RandomConnectionStrategy());

        ResultView.printLadderResult(participantNames, ladder);
    }

}
