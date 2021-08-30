package ladder.controller;

import java.util.List;

import ladder.domain.ExecutionResults;
import ladder.domain.Index;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.strategy.RandomlyMovableStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        List<String> names = Names.from(inputView.inputParticipantsName()).toStringList();
        List<String> results = Results.of(inputView.inputExecutionResult(), names.size()).toStringList();
        Ladder ladder = Ladder.from(names.size(), inputView.inputMaximumHeight(), new RandomlyMovableStrategy());
        ExecutionResults executionResults = ExecutionResults.of(names, results);

        resultView.outputLadder(executionResults, ladder.toList());
        loopStatement(executionResults, ladder);

        inputView.scannerClose();
    }

    private static void loopStatement(ExecutionResults executionResults, final Ladder ladder) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String name;
        do {
            name = inputView.inputWantedResultOfName();
            resultView.outputExecutionResult();
            outputAskResult(executionResults, ladder, name);
        } while (!"all".equals(name));
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
