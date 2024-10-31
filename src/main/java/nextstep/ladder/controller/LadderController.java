package nextstep.ladder.controller;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Persons persons = new Persons(InputView.requestNames());
        int heightCount = InputView.requestHeightCount();

        ResultView.print(persons, new Heights(persons.personCount(), heightCount));
    }

}
