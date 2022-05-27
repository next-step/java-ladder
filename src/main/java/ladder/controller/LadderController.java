package ladder.controller;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public void start() {
        InputView inputView = new InputView();
        List<String> person = inputView.person();
        int ladderSize = inputView.ladderSize();

        Ladder ladder = new Ladder(ladderSize, person.size());

        ResultView resultView = new ResultView();
        resultView.printPerson(person);
        resultView.printLadder(ladder);
    }
}
