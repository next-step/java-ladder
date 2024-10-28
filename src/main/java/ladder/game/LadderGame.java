package ladder.game;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Person;
import ladder.domain.Persons;
import ladder.generator.LineStrategy;
import ladder.generator.Strategy;
import ladder.view.ResultView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

public class LadderGame {

    public void play() {
        Persons persons = new Persons(participantQuestion());
        Strategy strategy = new LineStrategy();

        LadderResult ladderResult = LadderResult.from(persons, ladderResultQuestion());
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
