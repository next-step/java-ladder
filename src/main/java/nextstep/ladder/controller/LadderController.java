package nextstep.ladder.controller;

import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

import static nextstep.ladder.utils.StringUtil.*;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = createPlayers();
    }

    private Players createPlayers() {
        List<String> playerNames = splitWithComma(inputView.players());
        return Players.from(playerNames);
    }
}
