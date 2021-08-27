package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<String> names = Names.from(inputView.inputParticipantsName()).toStringList();
        List<String> results = Results.of(inputView.inputExecutionResult(), names.size()).toStringList();
        Ladder ladder = Ladder.from(names.size(), inputView.inputMaximumHeight());
        ExecutionResults executionResults = ExecutionResults.of(names, results);

        resultView.outputLadder(executionResults, ladder.toList());
        loopStatement(executionResults, ladder);

        inputView.scannerClose();
    }

    private static void loopStatement(ExecutionResults executionResults, final Ladder ladder) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        while (true) {
            String name = inputView.inputWantedResultOfName();
            resultView.outputExecutionResult();
            outputAskResult(executionResults, ladder, name);
        }
    }

    private static void outputAskResult(ExecutionResults executionResults, final Ladder ladder, final String name) {
        ResultView resultView = new ResultView();
        if ("all".equals(name)) {
            resultView.outputAskResultAll(ladder, executionResults);
            return;
        }
        Index index = Index.from(executionResults.toNameStringList().indexOf(name));
        resultView.outputAskResultOne(executionResults, ladder.resultIndexOf(index));
    }

}
