package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Results;
import ladder.service.LadderService;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderController {

    public static void main(String[] args) {
        String names = InputView.getParticipants();
        Participants participants = new Participants(names);

        Results results = new Results(InputView.getResultInput());

        int height = InputView.getHeightOfLadder();
        Ladder ladder = new Ladder(height, participants.countOfParticipants());
        ResultView.printLadder(participants, ladder, results);

        String selectedPerson = InputView.selectParticipants();

        if ("all".equals(selectedPerson)) {
            Map<String, String> allResults = LadderService.moveAllResultsPosition(participants, ladder, results);
            ResultView.printAllResults(allResults);
            return;
        }

        int moveResultPosition = LadderService.moveResultPosition(participants, ladder, selectedPerson);
        String result = LadderService.getResultName(results, moveResultPosition);
        ResultView.printResult(result);
    }
}
