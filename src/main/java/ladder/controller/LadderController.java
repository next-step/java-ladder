package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.bridge.BridgeFactory;
import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.RandomWay;
import ladder.domain.common.Height;
import ladder.domain.common.Range;
import ladder.domain.player.Names;
import ladder.domain.player.Players;
import ladder.domain.result.Destinations;
import ladder.domain.result.Prizes;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        Names names = new Names(InputView.inputNames());
        Prizes prizes = new Prizes(InputView.inputReward());
        Height height = new Height(InputView.inputHeight());

        Players players = names.toPlayers();
        Range range = names.makeRange(height);
        Destinations destinations = prizes.makeDestinations(range.getHeight());

        BridgeFactory bridgeFactory = new BridgeFactory(new RandomWay());
        Bridges bridges = bridgeFactory.makeBridges(range);

        Ladder ladder = new Ladder(players, bridges);

        OutputView.showLadder(ladder);
    }

}
