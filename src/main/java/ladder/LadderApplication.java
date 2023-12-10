package ladder;

import ladder.engine.LadderGenerator;
import ladder.factory.LadderFactoryBean;
import ladder.gilbert.GilbertLadder;
import ladder.gilbert.domain.data.*;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.showLadder;
import static ladder.view.ResultView.showResult;

public class LadderApplication {

    public static void main(String[] args) {
        Persons persons = inputNames();
        Goals goals = inputGoals();
        LadderHeight ladderHeight = inputLadderHeight();

        LadderGenerator ladderFactory = LadderFactoryBean.createLadderFactory();
        GilbertLadder ladder = (GilbertLadder) ladderFactory.generate(goals, ladderHeight);
        showLadder(persons, ladder.lines(), ladder.goals());

        Person person = inputPerson();
        if (person.hasAll()) {
            showResult(ladder.runAll(persons));
            return;
        }
        showResult(ladder.run(persons.find(person)));
    }

}
