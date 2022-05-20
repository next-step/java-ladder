package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private LadderController() {
    }

    public static void game() {
        List<Person> people = InputView.createPeople();
        List<Line> lines = InputView.inputMaxHeight(people.size());
        Ladder ladder = Ladder.create(people, lines);
        ResultView.printResult(ladder);
    }
}
