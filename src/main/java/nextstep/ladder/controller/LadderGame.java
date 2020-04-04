package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderGame {

    public static void play(InputView inputView, OutputView outputView) {
        List<Person> persons = inputView.getPersons();
        int height = inputView.getHeight();

        Ladder ladder = new Ladder(persons.size(), height);
        outputView.showLadder(ladder, persons);
    }
}
