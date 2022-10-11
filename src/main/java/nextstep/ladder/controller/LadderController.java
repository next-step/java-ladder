package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.DefaultStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Names;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
    public void start() {
        String inputNames = InputView.inputNames();
        Players players = Players.create(Names.of(inputNames));

        int height = Integer.parseInt(InputView.inputLadderHeight());
        DefaultStrategy strategy = new DefaultStrategy();
        Ladder ladder = Ladder.create(height, players, strategy);

        ResultView.showLadder(ladder);
    }
}
