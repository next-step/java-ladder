package net.chandol.ladder.v1.domain;

import net.chandol.ladder.v1.domain.bridge.Bridge;
import net.chandol.ladder.v1.domain.bridge.BridgesSupplier;
import net.chandol.ladder.v1.domain.bridge.ManualBridgeSupplier;
import net.chandol.ladder.v1.domain.player.Players;
import org.junit.Test;

import static java.util.Arrays.asList;
import static net.chandol.ladder.v1.value.Positive.pos;

public class LadderTest {

    @Test
    public void 사다리를만들어봅시다() {
        BridgesSupplier testBridges = testBridges(Bridge.of(0, 0), Bridge.of(2, 0));
        Ladder ladder = new Ladder(new Players("aaa", "bbb", "ccc"), pos(1), testBridges);
        ladder.hasBridge(pos(0), pos(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는높이를벗어날수없습니다() {
        new Ladder(new Players("aaa", "bbb"), pos(1), testBridges(Bridge.of(0, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는플레이어사이즈보다클수없습니다() {
        new Ladder(new Players("aaa"), pos(1), testBridges(Bridge.of(2, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는연속되어선안됩니다() {
        BridgesSupplier testBridges = testBridges(Bridge.of(0, 0), Bridge.of(1, 0));
        new Ladder(new Players("aaa", "bbb"), pos(1), testBridges);
    }

    private BridgesSupplier testBridges(Bridge... bridges) {
        return new ManualBridgeSupplier(asList(bridges));
    }
}