package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Persons persons = InputView.requestNames();
        Results results = InputView.requestResults();
        int heightCount = InputView.requestHeightCount();

        Ladders ladders = Ladders.of(persons.personCount(), heightCount);
        ResultView.printLadder(persons, ladders, results);

        PersonResults gameResult = LadderGame.result(persons, ladders, results);

        boolean endFlag = false;

        while (!endFlag) {
            String viewPerson = InputView.viewPerson();
            boolean isEnd = printResult(viewPerson, gameResult);
            endFlag = isEnd;
        }
    }

    private static boolean printResult(String viewPerson, PersonResults gameResult) {
        return ResultView.printGameResult(new Person(viewPerson), gameResult);
    }
}
