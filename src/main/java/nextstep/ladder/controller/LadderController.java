package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.LadderNavigator;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        List<String> participantNames = inputView.getParticipantNames();
        List<String> results = inputView.getResults();
        int height = inputView.getLadderHeight();

        Ladder ladder = LadderFactory.createLadder(participantNames, results, height);
        resultView.printLadder(ladder);

        LadderNavigator navigator = new LadderNavigator(ladder);

        LadderResults ladderResults = navigator.navigate();
        printResult(ladderResults);
    }

    private void printResult(LadderResults ladderResults) {
        final String printAllCmd = "all";

        while (true) {
            String targetParticipantName = inputView.getTargetParticipantName();

            if (printAllCmd.equals(targetParticipantName)) {
                resultView.printResultAll(ladderResults.getAll());
                break;
            }

            String result = ladderResults.getByName(targetParticipantName);
            resultView.printResult(result);
        }
    }

}
