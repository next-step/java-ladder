package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.LadderResult;
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

        LadderResult ladderResult = ladder.run();
        printResult(ladderResult);
    }

    private void printResult(LadderResult ladderResult) {
        while (true) {
            String targetParticipantName = inputView.getTargetParticipantName();

            if ("all".equals(targetParticipantName)) {
                resultView.printResultAll(ladderResult.getAll());
                break;
            }

            String result = ladderResult.getByName(targetParticipantName);
            resultView.printResult(result);
        }
    }

}
