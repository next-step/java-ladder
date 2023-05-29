package nextstep.ladder.controller;

import nextstep.ladder.Height;
import nextstep.ladder.Ladder;
import nextstep.ladder.Persons;
import nextstep.ladder.Results;
import nextstep.ladder.drawPolicy.RandomDraw;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class MainAction {

    public static void main(String args[]) {
        Persons persons = initPersons();
        Results results = initResults();
        Height ladderHeight = initHeight();

        ResultView.printPerson(persons);

        Ladder ladder = new Ladder(persons, ladderHeight, new RandomDraw());

        ResultView.printLadder(ladder.getLadder());
        ResultView.printLadderResults(results.getResults());

        // 결과 표출 while문
        while (true) {
            printResultByInput(persons, results, ladder);
        }
    }

    private static void printResultByInput(Persons persons, Results results, Ladder ladder) {
        InputView.printPersonResultInput();
        String nameForResultInput = InputView.stringInput();

        if (nameForResultInput.equalsIgnoreCase("all")) {
            ResultView.printAllResults(persons, results, ladder);
            return;
        }

        int startIndex = persons.getPersonIndex(nameForResultInput);
        int endIndex = ladder.getResultIndex(startIndex);
        ResultView.printResult(results, endIndex);

    }

    private static Results initResults() {
        InputView.printResultsInput();
        return new Results(InputView.stringInput()
                .split(","));
    }

    private static Height initHeight() {
        InputView.printLadderHeightInput();
        return new Height(InputView.intInput());
    }

    private static Persons initPersons() {
        InputView.printPersonInput();
        return new Persons(InputView.stringInput()
                .split(","));
    }
}
