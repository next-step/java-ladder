package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Participants participants = Participants.of(inputView.askParticipants());
        Prizes prizes = Prizes.of(inputView.askPrizes(), participants.getNumberOfParticipants());
        int heightOfLadder = inputView.askHeightOfLadder();
        Ladder ladder = LadderGenerator.generateLadder(heightOfLadder, participants, new RandomLadderGeneratorStrategy());
        LadderGameResult ladderGameResult = LadderGameResult.generateLadderGameResult(ladder, participants, prizes);

        outputView.showLadder(participants, ladder, prizes);

        List<Participant> targetParticipants = participants.findParticipants(inputView.askTargetParticipants());
        outputView.showLadderGameResult(targetParticipants, ladderGameResult);
    }

}
