package ladder.domain;

import ladder.domain.bridge.Bridge;
import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Destination;
import ladder.domain.result.Destinations;
import ladder.domain.result.Prize;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void 사다리게임_결과생성() {
        Player chan = getPlayerHelper("chan", 0);
        Player in = getPlayerHelper("in", 1);
        Players players = new Players(Arrays.asList(chan, in));

        Bridge chanBridge = getBridgeHelper(0, 1, Direction.DOWN);
        Bridge inBridge = getBridgeHelper(1, 1, Direction.DOWN);
        Bridges bridges = new Bridges(Arrays.asList(chanBridge, inBridge));

        Destination chanDestination = getDestinationHelper(0, 2, "100");
        Destination inDestination = getDestinationHelper(1, 2, "꽝");
        Destinations destinations = new Destinations(Arrays.asList(chanDestination, inDestination));

        Result chanResult = new Result(chan, chanDestination);
        Result inResult = new Result(in, inDestination);
        Results maybeResults = new Results(Arrays.asList(chanResult, inResult));

        Ladder ladder = new Ladder(players, bridges);

        Results results = ladder.makeResults(destinations);

        assertThat(results).isEqualTo(maybeResults);
    }

    public Player getPlayerHelper(String name, int x) {
        return new Player(new Name(name), new Point(x, 0));
    }

    public Bridge getBridgeHelper(int x, int y, Direction direction) {
        return new Bridge(new Point(x, y), direction);
    }

    public Destination getDestinationHelper(int x, int y, String value) {
        return new Destination(new Prize(value), new Point(x, y));
    }
}