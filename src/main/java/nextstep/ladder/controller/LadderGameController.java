package nextstep.ladder.controller;

import static java.util.stream.Collectors.*;

import java.util.List;

import nextstep.ladder.model.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            doRun();
        } catch (Exception e) {

        }
    }

    private void doRun() {
        List<String> peopleNames = inputView.getPeopleNames();
        List<Person> people = peopleNames.stream()
            .map(Person::new)
            .collect(toList());

        resultView.printResult(people);
    }
}
