package ladder;

import ladder.domain.data.*;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.showLadder;
import static ladder.view.ResultView.showResult;

public class LadderApplication {

    public static void main(String[] args) {
        Persons persons = inputNames();
        Goals goals = inputGoals();
        LadderHeight ladderHeight = inputLadderHeight();

        Ladder ladder = Ladder.of(goals, ladderHeight);
        showLadder(persons, ladder);

        Person person = inputPerson();
        if (person.hasAll()) {
            showResult(ladder.runAll(persons));
            return;
        }
        showResult(ladder.run(persons.find(person)));
    }

}
