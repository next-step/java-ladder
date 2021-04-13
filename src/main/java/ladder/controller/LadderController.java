package ladder.controller;

import ladder.domain.ExecutionResultMap;
import ladder.domain.ExecutionResults;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderExecutionResults;
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

        LadderExecutionResults ladderExecutionResults = LadderExecutionResults.of(ladder, executionResults);
        ExecutionResultMap executionResultMap = ExecutionResultMap.of(persons, ladderExecutionResults);
        while (true) {
            String personName = inputView.inputPersonName();
            checkSystemExit(personName, executionResultMap);
            resultView.printExecutionResult(executionResultMap, personName);
        }
    }

    private void checkSystemExit(String personName, ExecutionResultMap executionResultMap) {
        if (personName.equals("all")) {
            resultView.printAllExecutionResult(executionResultMap);
            System.exit(0);
        }
    }
}
