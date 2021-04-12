package ladder.controller;

import ladder.domain.ExecutionResultMap;
import ladder.domain.ExecutionResults;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Random;

public class LadderController {
    private static final Random random = new Random();

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    public void run() {
        Persons persons = Persons.from(inputView.inputPersonNames());
        ExecutionResults executionResults = ExecutionResults.from(inputView.inputExecutionResults(), persons.getCountOfPerson());
        Height height = Height.from(inputView.inputLadderHeight());

        Ladder ladder = Ladder.of(height.getHeight(), persons.getPersons().size(), random::nextBoolean);
        resultView.printPersons(persons);
        resultView.printLadder(ladder);
        resultView.printExecutionResults(executionResults);

        ExecutionResultMap executionResultMap = ExecutionResultMap.of(persons, executionResults, ladder);
        while (true) {
            String personName = inputView.inputPersonName();
            resultView.printExecutionResult(executionResultMap, personName);
        }
    }
}
