package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.bridge.BridgeFactory;
import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.RandomWay;
import ladder.domain.common.Height;
import ladder.domain.common.Range;
import ladder.domain.player.Name;
import ladder.domain.player.Names;
import ladder.domain.player.Players;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LadderController {

    public static void main(String[] args) {
        List<Name> allNames = makeNames(InputView.inputNames());

        Names names = new Names(allNames);
        Height height = new Height(InputView.inputHeight());

        Players players = names.toPlayers();
        Range range = names.makeRange(height);

        BridgeFactory bridgeFactory = new BridgeFactory(new RandomWay());
        Bridges bridges = bridgeFactory.makeLadder(range);

        Ladder ladder = new Ladder(players, bridges);

        OutputView.showLadder(ladder);
    }

    private static List<Name> makeNames(String[] inputNames) {
        return Arrays.stream(inputNames)
                .map(Name::new)
                .collect(toList());
    }
}
