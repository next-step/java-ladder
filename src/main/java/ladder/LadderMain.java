package ladder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderMain {
    public static void main(String[] args) {
        List<String> names = InputView.inputPersonNames();
        List<String> resultList = InputView.inputPlayResults();
        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, names.size(), new HorizontalLineRandomStrategy());
        OutputView.printLadder(names, ladderHeight, ladder, resultList);

        Persons persons = new Persons(names);
        Results results = new Results(resultList);
        String name = InputView.inputResultName();
        if (name.equals("all")) {
            Map<Person, Result> resultMap = persons.findAllFinalIndex(ladder)
                    .entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> results.findResultOf(e.getValue())));
            OutputView.pringResultAll(resultMap);
        } else {
            Result result1 = results.findResultOf(persons.findResultOf(new Person(name), ladder));
            OutputView.printResultOne(result1);
        }

    }
}
