package ladder.controller;

import ladder.service.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String[] participantNames = InputView.inputParticipantNames();
        int participantCount = participantNames.length;
        int maxLadderHeight = InputView.inputMaxLadderHeight();

        Ladder ladder = new Ladder(maxLadderHeight, participantCount);

        ResultView.printLadderResult(participantNames, ladder);
    }

}
