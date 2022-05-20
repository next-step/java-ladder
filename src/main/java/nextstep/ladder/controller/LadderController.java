package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private LadderController() {
    }

    public static void game() {
        List<String> names = InputView.inputNames();
        List<Person> people = Person.of(names);
        ResultView.println();

        int maxHeight = InputView.inputMaxHeight();
        ResultView.println();

        Ladder ladder = Ladder.create(people, maxHeight);
        ResultView.printResult(ladder);
    }
}
