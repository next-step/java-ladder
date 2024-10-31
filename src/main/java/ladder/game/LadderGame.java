package ladder.game;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.generator.LineStrategy;
import ladder.generator.Strategy;
import ladder.view.ResultView;

import static ladder.view.InputView.*;

public class LadderGame {

    public void play() {
        Persons persons = Persons.from(participantQuestion());
        Strategy strategy = new LineStrategy();

        LadderResult ladderResult = LadderResult.of(persons, ladderResultQuestion());
        Ladder ladder = Ladder.of(persons.getSize(), ladderCountQuestion(), strategy);
        makePlayResults(persons, ladder);

        ResultView resultView = new ResultView(ladderResult, persons);
        resultView.getResultView(ladder);
    }

    private static void makePlayResults(Persons persons, Ladder ladder) {
        for(Person person : persons.getPersons()) {
            int personLadderResult = ladder.getPersonLadderResult(person.getPoint());
            person.gameResultSave(personLadderResult);
        }
    }

}
