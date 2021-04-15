package step3.controller;


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
        Ladder lines = new Ladder(new Height(height), persons.personList().size());
        resultView.printLadder(lines);

        resultView.executionResultLine(executionResults);
        
        while (true) {
            String resultName = inputView.inputPerson();
            int personIndex = persons.getPersonIndex(new Person(resultName));
            checkInputAll(persons, lines.getExecutionResult(executionResults), resultName);
            resultView.printExecutionResult(lines.getExecutionResult(executionResults), personIndex);
        }
    }

    private void checkInputAll(Persons persons, ExecutionResults result, String resultName) {
        if (resultName.equals("all")) {
            resultView.printAllExecutionResult(result, persons);
            System.exit(0);
        }
    }
}
