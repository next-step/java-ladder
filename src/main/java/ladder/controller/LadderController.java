package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.Participants;
import ladder.strategy.RandomLadderStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void run() {
        String inputNames = InputView.inputParticipantNames();
        int maximumHeight = InputView.inputMaximumHeightOfLadder();
        Participants participants = new Participants(inputNames);
        Ladder ladder = new Ladder(participants.countParticipantPerson(), maximumHeight, new RandomLadderStrategy());
        LadderGame ladderGame = new LadderGame(participants, ladder);
        ResultView.printResult(ladderGame);
    }
}
