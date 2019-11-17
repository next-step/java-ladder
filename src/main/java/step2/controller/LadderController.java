package step2.controller;

import step2.domain.Ladder;
import step2.domain.Participants;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String names = InputView.getParticipants();
        Participants participants = new Participants(names);

        int height = InputView.getHeightOfLadder();
        Ladder ladder = new Ladder(height, participants.countOfParticipants());

        ResultView.printResult(participants, ladder);
    }
}
