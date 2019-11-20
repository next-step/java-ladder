package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String names = InputView.getParticipants();
        Participants participants = new Participants(names);

        Results results = new Results(InputView.getResultInput());

        int height = InputView.getHeightOfLadder();
        Ladder ladder = new Ladder(height, participants.countOfParticipants());
        ResultView.printLadder(participants, ladder, results);

        String selectedPerson = InputView.selectParticipants();

        int positionOfPerson = participants.findPosition(selectedPerson);

        int moveResultPosition = ladder.move(positionOfPerson);
        String result = results.getResultName(moveResultPosition);

        ResultView.printResult(result);
    }
}
