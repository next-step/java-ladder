package nextstep.ladder.controller;

import nextstep.ladder.Height;
import nextstep.ladder.Ladder;
import nextstep.ladder.Persons;
import nextstep.ladder.drawPolicy.RandomDraw;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class MainAction {

    public static void main(String args[]) {
        Persons persons = initPersons();
        Height ladderHeight = initHeight();

        ResultView.printResult(persons);

        Ladder ladder = new Ladder(persons, ladderHeight, new RandomDraw());

        ResultView.printLadder(ladder.getLadder());
    }

    private static Height initHeight() {
        InputView.printLadderHeightInput();
        return new Height(InputView.intInput());
    }

    private static Persons initPersons() {
        InputView.printPersonInput();
        return new Persons(InputView.stringInput()
                .split(","));
    }
}
