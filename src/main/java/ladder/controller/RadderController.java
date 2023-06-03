package ladder.controller;

import ladder.domain.Persons;
import ladder.domain.Prize;
import ladder.domain.Radder;
import ladder.view.InputView;
import ladder.view.ResultView;

public class RadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesOfPersons = inputView.promptNamesOfPersons();
        String prizes = inputView.promptPrizes();
        int heightOfRadder = inputView.promptHeightOfRadder();

        Persons persons = Persons.of(namesOfPersons);
        Prize prize = Prize.of(prizes, persons.getCount());

        Radder radder = Radder.of(persons.getCount(), heightOfRadder);

        ResultView resultView = new ResultView();
        resultView.viewRadderResult(persons, radder, prize);

    }
}
