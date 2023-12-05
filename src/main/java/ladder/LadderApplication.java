package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.domain.LineGenerator;
import ladder.domain.RandomBooleanGenerator;
import ladder.domain.data.*;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

public class LadderApplication {

    public static void main(String[] args) {
        Persons persons = inputNames();
        Goals goals = inputGoals();
        LadderHeight ladderHeight = inputLadderHeight();

        LineGenerator generator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> generator.generate(persons.size()))
            .limit(ladderHeight.value())
            .collect(Collectors.toList());
        Ladder ladder = new Ladder(lines, goals);

        showPersons(persons);
        showLines(ladder);
        showGoals(goals);

        Person person = inputPerson();
        if (person.hasAll()) {
            showResult(ladder.runAll(persons));
            return;
        }
        showResult(ladder.run(persons.find(person)));
    }
}
