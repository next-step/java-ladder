package ladder.controller;

import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.domain.Radder;
import ladder.view.InputView;
import ladder.view.ResultView;

public class RadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesOfPersons = inputView.promptNamesOfPersons();
        int heightOfRadder = inputView.promptHeightOfRadder();

        Persons persons = new Persons(namesOfPersons);
        Radder radder = new Radder(persons.getCount(), heightOfRadder);

        ResultView resultView = new ResultView();
        resultView.viewResult(persons, radder);
    }
}
