package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.ladderview.InputView;
import nextstep.ladder.ladderview.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Participants participants = new Participants(inputView.inputName());
        int numberOfParticipants = participants.getParticipantCount();
        int height = inputView.inputHeight();
        Ladders ladders = new Ladders(height, numberOfParticipants);
        ladders.createLines();
        resultView.printResult(participants.getParticipants(), ladders.getLadderState());
    }

}
