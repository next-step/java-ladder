package nextstep.ladder.controller;

import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.People;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderController {

    public void startGame() {
        List<Person> people = new People(Input.inputPerson()).people();
        List<HorizontalLine> horizontalLines = new Ladder(people, Input.inputHeightOfLadder()).horizontalLines();

        Output.printLadder(people, horizontalLines);
    }
}
