package nextstep.ladder.controller;

import nextstep.ladder.domain.ConnectionCreationStrategyImpl;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    public static Players getPlayers() {
        String names = InputView.getNames();
        return Players.from(names);
    }

    public static int getHeight() {
        return InputView.getHeight();
    }

    public static Lines createLines(Players players, int height) {
        return Lines.fromHeight(players.getSize() - 1, height, new ConnectionCreationStrategyImpl());
    }

    public static void showPlayers(Players players) {
        OutputView.showPlayers(players);
    }

    public static void showLines(Lines lines) {
        OutputView.showLines(lines);
    }

    public static Results getResults(int size) {
        return Results.from(size, InputView.getResults());
    }

    public static void showResults(Results results) {
        OutputView.showResults(results);
    }
}
