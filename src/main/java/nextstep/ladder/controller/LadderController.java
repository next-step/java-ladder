package nextstep.ladder.controller;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.LadderView;
import nextstep.ladder.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderController {
    public void start() {
        String[] inputNames = InputView.inputNames();

        Players players = Players.create(inputNames);
        String[] results = InputView.inputResults();
        int height = InputView.inputLadderHeight();

        Game game = new Game(players, results, height);
        ResultView.showLadder(new LadderView(game.getLadder(), players));

        System.out.println(Stream.of(results)
                .map(result -> String.format("%6s", result))
                .collect(Collectors.joining()));

        showResult(game);
    }

    private void showResult(Game game) {
        String playerName = InputView.inputPlayerName();

        if (playerName.equals("all")) {
            String result = game.getResult(playerName);
            ResultView.showResult(result);
            return;
        }

        String result = game.getResult(playerName);
        ResultView.showResult(result);
        showResult(game);
    }
}
