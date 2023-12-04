package ladder;

import ladder.domain.LineGenerator;
import ladder.domain.RandomBooleanGenerator;
import ladder.domain.data.*;
import ladder.view.InputView;

import static ladder.view.ResultView.personNames;
import static ladder.view.ResultView.result;

public class LadderApplication {

    public static void main(String[] args) {
        PersonNames personNames = InputView.inputNames();
        Goals goals = InputView.inputGoals();
        LadderHeight ladderHeight = InputView.inputLadderHeight();

        LineGenerator generator = new LineGenerator(new RandomBooleanGenerator());
        Ladder ladder = new Ladder(goals);
        for (int i = 0; i < ladderHeight.value(); i++) {
            ladder.add(generator.generate(personNames.size()));
        }
        personNames(personNames);
        result(ladder.lines());
    }
}
