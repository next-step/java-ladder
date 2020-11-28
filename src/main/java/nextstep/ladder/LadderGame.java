package nextstep.ladder;

import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.util.ValidInputHelper;
import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static final String ALL_KEYWORD_USED_ERR_MSG = "참석자의 이름으로 " + ConsoleInputView.ALL_KEYWORD + "은(는) 사용할 수 없습니다.";
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
        Results results = ValidInputHelper.get(() -> getResults(participants), inputView::printError);
        resultView.printLadder(participants, ladder, results);
        printExecutionResults(participants, ladder, results);
    }

    private Participants getParticipants() {
        List<String> inputNames = ValidInputHelper.get(inputView::getParticipantNames, inputView::printError);
        validateKeyword(inputNames);
        return Participants.from(inputNames);
    }

    private void validateKeyword(List<String> inputNames) {
        boolean hasAllKeyword = inputNames.stream()
                .anyMatch(ConsoleInputView.ALL_KEYWORD::equals);

        if (hasAllKeyword) {
            throw new IllegalArgumentException(ALL_KEYWORD_USED_ERR_MSG);
        }
    }

    private Height getHeight() {
        int inputHeight = ValidInputHelper.get(inputView::getHeight, inputView::printError);
        return Height.valueOf(inputHeight);
    }

    private Results getResults(Participants participants) {
        List<String> results = ValidInputHelper.get(inputView::getResults, inputView::printError);
        return Results.of(participants.getNumberOfParticipants(), results);
    }

    private void printExecutionResults(Participants participants, Ladder ladder, Results results) {
        ExecutionResults executionResults = ladder.resultOf(participants, results);
        for (boolean printedAll = false; !printedAll; ) {
            String nameOfWantToCheckInput = inputView.getNameOfWantToCheck();
            Name nameOfWantToCheck = Name.valueOf(nameOfWantToCheckInput);
            printedAll = resultView.printResult(executionResults, nameOfWantToCheck);
        }
    }
}
