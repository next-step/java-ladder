package nextstep.ladder;

import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.util.ValidInputHelper;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

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
        Results results = ValidInputHelper.get(() -> getExecutionResults(participants), inputView::printError);
        resultView.printLadder(participants, ladder, results);
        printResults(participants, ladder, results);
    }

    private Participants getParticipants() {
        List<String> inputNames = ValidInputHelper.get(inputView::getParticipantNames, inputView::printError);
        return Participants.from(inputNames);
    }

    private Height getHeight() {
        int inputHeight = ValidInputHelper.get(inputView::getHeight, inputView::printError);
        return Height.valueOf(inputHeight);
    }

    private Results getExecutionResults(Participants participants) {
        List<String> executionResults = ValidInputHelper.get(inputView::getExecutionResults, inputView::printError);
        return Results.of(participants, executionResults);
    }

    private void printResults(Participants participants, Ladder ladder, Results results) {
        ExecutionResults executionResults = ladder.resultOf(participants, results);
        for (boolean printedAll = false; !printedAll; ) {
            String nameOfWantToCheckInput = inputView.getNameOfWantToCheck();
            Name nameOfWantToCheck = Name.valueOf(nameOfWantToCheckInput);
            printedAll = resultView.printResult(executionResults, nameOfWantToCheck);
        }
    }
}
