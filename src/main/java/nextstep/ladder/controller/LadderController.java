package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.DefaultEnablePointStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.LadderView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public void start() {
        String[] inputNames = InputView.inputNames();
        Players players = Players.create(inputNames);

        String[] results = InputView.inputResults();

        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.create(height, players, new DefaultEnablePointStrategy());

        ResultView.showLadder(new LadderView(ladder, players));
    }
}
