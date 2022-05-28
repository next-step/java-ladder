package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    public static void start() {
        List<String> names = InputView.inputPerson();
        List<String> results = InputView.inputResults();
        List<Person> persons = names.stream()
                .map(name -> Person.of(name))
                .collect(Collectors.toList());
        LadderResult ladderResult = LadderResult.of(names);

        int height = InputView.inputHeight();
        LineStrategy lineStrategy = new DeduplicationStrategy();
        Ladder ladder = Ladder.of(lineStrategy, height, persons.size());
        ladderResult.findLadderResult(ladder, results);
        ResultView.printName(persons);
        ResultView.drawLadders(ladder, results);
        ResultView.resultFinal(ladderResult, InputView.inputFinalResult());
    }
}
