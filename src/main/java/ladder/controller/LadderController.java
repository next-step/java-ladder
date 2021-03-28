package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Person;
import ladder.domain.Winning;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public void start() {
        InputView inputView = new InputView();
        String inputPerson = inputView.person();
        String inputWinning = inputView.winning();
        int ladderSize = inputView.ladderSize();

        Person person = new Person(inputPerson);
        Winning winning = new Winning(inputWinning, person.countOfPerson());
        Ladder ladder = new Ladder(ladderSize, person.countOfPerson());

        LadderResult ladderResult = LadderResult.of(person, winning, ladder);

        ResultView resultView = new ResultView();
        resultView.printPerson(person);
        resultView.printLadder(ladder);
        resultView.printWinning(winning);
        resultView.printLadderResult(ladderResult);
    }
}
