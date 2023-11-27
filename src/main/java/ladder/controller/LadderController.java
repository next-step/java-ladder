package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        InputView inputView = new InputView();
        List<String> persons = inputView.persons();
        int ladderSize = inputView.ladderSize();

        Ladder ladder = new Ladder(persons.size(), ladderSize);

        ResultView resultView = new ResultView();
        resultView.printPerson(persons);
        resultView.printLadder(ladder);
    }
}