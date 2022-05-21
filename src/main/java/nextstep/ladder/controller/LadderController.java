package nextstep.ladder.controller;

import nextstep.ladder.model.ladder.Ladder;
import nextstep.ladder.model.player.People;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private LadderController() {
    }

    public static void game() {
        List<String> names = InputView.inputNames();
        People people = People.of(names);
        ResultView.println();

        List<String> scores = InputView.inputScores();
        ResultView.println();

        int maxHeight = InputView.inputMaxHeight();
        ResultView.println();

        Ladder ladder = Ladder.create(people.size(), maxHeight, scores);
        ResultView.printLadder(ladder);
    }
}
