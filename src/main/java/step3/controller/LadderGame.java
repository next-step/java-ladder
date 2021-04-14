package step3.controller;


import step3.domain.Result;
import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LadderGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        String participants = inputView.inputParticipant();
        Persons persons = new Persons(participants);
        ExecutionResults executionResults = new ExecutionResults(inputView.inputExecutionResult());
        int height = inputView.inputHeight();

        resultView.printPerson(persons);
        Lines lines = new Lines(new Height(height), persons.personList().size());
        resultView.printLadder(lines);

        Result result = new Result(lines, executionResults);
        resultView.executionResultLine(executionResults);
        
        while (true) {
            String resultName = inputView.inputPerson();
            int personIndex = persons.getPersonIndex(new Person(resultName));
            checkInputAll(persons, result, resultName);
            resultView.printExecutionResult(result, personIndex);
        }
    }

    private void checkInputAll(Persons persons, Result result, String resultName) {
        if (resultName.equals("all")) {
            resultView.printAllExecutionResult(result, persons);
            System.exit(0);
        }
    }
}
