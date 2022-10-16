package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.DefaultEnablePointStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.LadderResult;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.view.InputView.DEFAULT_DELIMITER;

public class LadderController {
    public void start() {
        String inputNames = InputView.inputNames();
        Players players = Players.create(inputNames, DEFAULT_DELIMITER);

        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.create(height, players, new DefaultEnablePointStrategy());

        ResultView.showLadder(new LadderResult(ladder));
    }
}
