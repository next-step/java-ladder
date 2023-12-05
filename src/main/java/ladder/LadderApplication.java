package ladder;

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
        Ladder ladder = new Ladder(goals);
        for (int i = 0; i < ladderHeight.value(); i++) {
            ladder.add(generator.generate(persons.size()));
        }
        showPersons(persons);
        ladderResult(ladder);

        Person person = inputPerson();
        Goal goal = ladder.run(persons.find(person));
        goalResult(goal);

    }
}
