package ladder;

import ladder.engine.LadderGenerator;
import ladder.factory.LadderFactoryBean;
import ladder.gilbert.GilbertLadder;
import ladder.gilbert.domain.data.*;

import static ladder.gilbert.view.InputView.*;
import static ladder.gilbert.view.ResultView.showLadder;
import static ladder.gilbert.view.ResultView.showResult;

public class GilbertLadderApplication {

    public static void main(String[] args) {
        Persons persons = inputNames();
        Goals goals = inputGoals();
        LadderHeight ladderHeight = inputLadderHeight();

        LadderGenerator ladderFactory = LadderFactoryBean.createLadderFactory();
        GilbertLadder ladder = (GilbertLadder) ladderFactory.generate(persons.size(), ladderHeight.value());
        showLadder(persons, ladder.lines(), goals);

        Person person = inputPerson();
        if (person.hasAll()) {
            showResult(ladder.runAll(persons.size()), persons, goals);
            return;
        }
        showResult(ladder.run(persons.toOrder(person)), persons, goals);
    }

}
