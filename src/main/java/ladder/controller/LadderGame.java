package ladder.controller;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Lines;
import ladder.domain.result.ExpectedResults;
import ladder.domain.result.Results;
import ladder.domain.user.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        Participants participants = inputView.getParticipantNames();
        ExpectedResults expectedResults = inputView.getExpectedResults(participants.size());
        LadderHeight ladderHeight = inputView.getLadderHeight();
        Lines lines = Lines.from(ladderHeight.getHeight(), participants.size());

        resultView.printParticipants(participants);
        resultView.printLadder(lines);
        resultView.printExpectedResults(expectedResults);
        Results results = lines.getResult(participants, expectedResults);

        String desireParticipantName = inputView.getDesireParticipantName();
        Participants desireParticipants = participants.getDesireParticipants(desireParticipantName);
        resultView.printResults(results.getDesireResults(desireParticipants));
    }

}
