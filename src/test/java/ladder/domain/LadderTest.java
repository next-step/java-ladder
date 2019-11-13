package ladder.domain;

import ladder.domain.bridge.Bridge;
import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Destination;
import ladder.domain.result.Destinations;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.TestHelper.getBridgeHelper;
import static ladder.TestHelper.getDestinationHelper;
import static ladder.TestHelper.getPlayerHelper;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리게임_결과생성() {
        Player chan = getPlayerHelper("chan", 0);
        Player in = getPlayerHelper("in", 1);
        Players players = new Players(Arrays.asList(chan, in));

        Bridge chanBridge1 = getBridgeHelper(0, 1, Direction.DOWN);
        Bridge chanBridge2 = getBridgeHelper(0, 2, Direction.DOWN);
        Bridge inBridge1 = getBridgeHelper(1, 1, Direction.DOWN);
        Bridge inBridge2 = getBridgeHelper(1, 2, Direction.DOWN);
        Bridges bridges = new Bridges(Arrays.asList(chanBridge1, inBridge1, chanBridge2, inBridge2));

        Destination chanDestination = getDestinationHelper(0, 3, "100");
        Destination inDestination = getDestinationHelper(1, 3, "꽝");
        Destinations destinations = new Destinations(Arrays.asList(chanDestination, inDestination));

        Result chanResult = new Result(chan, chanDestination);
        Result inResult = new Result(in, inDestination);
        Results maybeResults = new Results(Arrays.asList(chanResult, inResult));

        Ladder ladder = new Ladder(players, bridges);

        Results results = ladder.makeResults(destinations);

        assertThat(results).isEqualTo(maybeResults);
    }

}