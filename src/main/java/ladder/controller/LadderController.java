package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        InputView inputView = new InputView();
        String inputPerson = inputView.person();
        int ladderSize = inputView.ladderSize();

        Person person = new Person(inputPerson);
        Ladder ladder = new Ladder(ladderSize, person.countOfPerson());

        ResultView resultView = new ResultView();
        resultView.printPerson(person);
        resultView.printLadder(ladder);
    }
}
