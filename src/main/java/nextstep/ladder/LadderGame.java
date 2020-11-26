package nextstep.ladder;

import nextstep.ladder.domain.ExecutionsResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.util.ValidInputHelper;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Participants participants = ValidInputHelper.get(this::getParticipants, inputView::printError);
        Height height = ValidInputHelper.get(this::getHeight, inputView::printError);
        Ladder ladder = Ladder.of(participants, height);
        ExecutionsResults executionsResults = ValidInputHelper.get(() -> getExecutionResults(participants), inputView::printError);
        resultView.printLadder(participants, ladder, executionsResults);
        printResults(participants, ladder, executionsResults);
    }

    private Participants getParticipants() {
        List<String> inputNames = ValidInputHelper.get(inputView::getParticipantNames, inputView::printError);
        return Participants.from(inputNames);
    }

    private Height getHeight() {
        int inputHeight = ValidInputHelper.get(inputView::getHeight, inputView::printError);
        return Height.valueOf(inputHeight);
    }

    private ExecutionsResults getExecutionResults(Participants participants) {
        List<String> executionResults = ValidInputHelper.get(inputView::getExecutionResults, inputView::printError);
        return ExecutionsResults.of(participants, executionResults);
    }

    private void printResults(Participants participants, Ladder ladder, ExecutionsResults executionsResults) {
        Results results = getResults(participants, ladder, executionsResults);
        for (boolean printedAll = false; !printedAll; ) {
            String nameOfWantToCheck = inputView.getNameOfWantToCheck();
            printedAll = resultView.printResult(results, nameOfWantToCheck);
        }
    }

    private Results getResults(Participants participants, Ladder ladder, ExecutionsResults executionsResults) {
        Map<String, String> resultsInput = ladder.resultOf(participants, executionsResults);
        return Results.of(resultsInput);
    }
}
