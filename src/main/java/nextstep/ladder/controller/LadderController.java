package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.People;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String peopleStr = inputView.inputPeople();
        People people = new People(peopleStr);
        int ladderHeight = inputView.inputLadderHeight();

        Ladder ladder = new Ladder(people.getPeople().length, ladderHeight);

        ResultView resultView = new ResultView();
        resultView.printLadder(people.getPeople(), ladderHeight, ladder.getLines());
    }
}
