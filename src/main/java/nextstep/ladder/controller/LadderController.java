package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Persons persons = new Persons(InputView.requestNames());
        int heightCount = InputView.requestHeightCount();
        LadderGame ladderGame = new LadderGame(persons, heightCount);
        ResultView.print(ladderGame);
    }

}
