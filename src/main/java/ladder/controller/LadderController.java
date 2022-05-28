package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    public static void start() {
        List<Person> persons = InputView.inputPerson().stream()
                .map(name -> Person.of(name))
                .collect(Collectors.toList());
        int height = InputView.inputHeight();
        ResultView.printName(persons);
        ResultView.resultLadders(Ladder.of(height, persons.size()));
    }
}
