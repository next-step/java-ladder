package nextstep.ladder.controller;

import nextstep.ladder.model.Game;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    private LadderController() {
    }

    public static void game() {
        List<String> names = InputView.inputNames();
        ResultView.println();

        List<String> scores = InputView.inputScores();
        ResultView.println();

        int maxHeight = InputView.inputMaxHeight();
        ResultView.println();

        Game game = Game.ready(names, scores, maxHeight);
        ResultView.printLadder(game.people(), game.ladder());

        names.forEach(name -> {
            String n = InputView.inputName();
            ResultView.printResult(n, game);
        });
    }
}
