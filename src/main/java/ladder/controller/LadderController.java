package ladder.controller;

import ladder.model.Ladder;
import ladder.model.LadderGenerator;
import ladder.model.Participants;
import ladder.model.RandomLadderGeneratorStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = Participants.of(inputView.askParticipants());
        int heightOfLadder = inputView.askHeightOfLadder();
        Ladder ladder = LadderGenerator.generateLadder(heightOfLadder, participants, new RandomLadderGeneratorStrategy());
        outputView.showResult(participants, ladder);
    }

}
