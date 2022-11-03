package ladder.controller;

import ladder.domain.LadderHeight;
import ladder.domain.Lines;
import ladder.domain.Participant;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        List<Participant> participants = inputView.getParticipantNames();
        LadderHeight ladderHeight = inputView.getLadderHeight();
        Lines lines = new Lines(ladderHeight.getHeight(), participants.size());
        resultView.printParticipants(participants);
        resultView.printLadder(lines.getLines());
    }
}
