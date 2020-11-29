package nextstep.ladder.controller;

import nextstep.ladder.domain.ConnectionCreationStrategyImpl;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
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

    public static void showResult(Players players, Lines lines) {
        OutputView.showPlayers(players);
        OutputView.showLines(lines);
    }
}
