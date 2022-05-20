package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private LadderController() {
    }

    public static void game() {
        List<Person> people = createPeople();
        ResultView.println();

        int maxHeight = InputView.inputMaxHeight();
        ResultView.println();

        Ladder ladder = Ladder.create(people, maxHeight);
        ResultView.printResult(ladder);
    }

    private static List<Person> createPeople() {
        List<String> names = InputView.inputNames();
        return names
                .stream()
                .map(Person::is)
                .collect(Collectors.toList());
    }
}
