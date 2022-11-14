package ladder;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.ui.InputView;
import ladder.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderMain {
    public static void main(String[] args) {
        List<Person> persons = InputView.inputNames().stream()
                .map(Person::new)
                .collect(Collectors.toList());
        int height = InputView.inputHeight();

        ResultView.resultMessagePrint();
        ResultView.printName(persons);
        ResultView.resultLadders(new Ladder(height, persons.size()));
    }
}
