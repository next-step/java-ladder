package step3.controller;


import step3.Result;
import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LadderGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void game() {
        String participants = inputView.inputParticipant();
        Persons persons = new Persons(participants);
        ExecutionResults executionResults = new ExecutionResults(inputView.inputExecutionResult());
        int height = inputView.inputHeight();

        resultView.printPerson(persons);
        Lines lines = new Lines(new Height(height), persons.personList().size());
        resultView.printLadder(lines);
        Result result = lines.result(persons, executionResults);
        resultView.executionResultLine(result);

        while (true) {
            String resultName = inputView.inputPerson();
            Person person = new Person(resultName);
            if (resultName.equals("all")) {
                resultView.printAllExecutionResult(result);
                System.exit(0);
            }
            resultView.printExecutionResult(result, person);
        }
    }
}
