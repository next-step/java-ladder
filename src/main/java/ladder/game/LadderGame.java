package ladder.game;

import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.generator.LineStrategy;
import ladder.generator.Strategy;

import static ladder.view.InputView.ladderCountQuestion;
import static ladder.view.InputView.participantQuestion;
import static ladder.view.ResultView.*;

public class LadderGame {

    public void play() {
        Persons persons = new Persons(participantQuestion());
        Strategy strategy = new LineStrategy();
        Ladder ladder = Ladder.of(persons.getSize(), ladderCountQuestion(), strategy);

        getResultView(ladder, persons);
    }
}
