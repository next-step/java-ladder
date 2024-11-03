package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Persons persons = new Persons(InputView.requestNames());
        Results results = new Results(InputView.requestResults());
        int heightCount = InputView.requestHeightCount();

        Ladders ladders = new Ladders(persons.personCount(), heightCount);
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
        if (isAll(viewPerson)) {
            ResultView.printGameResultAll(gameResult.searchName(viewPerson));
            return true;
        }
        ResultView.printGameResult(gameResult.searchName(viewPerson).get(0));
        return false;
    }

    private static boolean isAll(String viewPerson) {
        return viewPerson.equals("all");
    }

}
