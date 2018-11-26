package net.chandol.domain;

import net.chandol.domain.bridge.BridgesSupplier;
import net.chandol.domain.bridge.ManualBridgeSupplier;
import net.chandol.domain.bridge.Bridge;
import org.junit.Test;

import static java.util.Arrays.asList;
import static net.chandol.value.Positive.pos;

public class LadderTest {

    @Test
    public void 사다리를만들어봅시다() {
        Ladder ladder = new Ladder(pos(3), pos(1), testBridges(Bridge.of(0, 0), Bridge.of(2, 0)));
        ladder.hasBridge(pos(0), pos(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는높이를벗어날수없습니다() {
        new Ladder(pos(2), pos(1), testBridges(Bridge.of(0, 1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는라인사이즈보다클수없습니다() {
        new Ladder(pos(2), pos(1), testBridges(Bridge.of(2, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사다리는연속되어선안됩니다() {
        new Ladder(pos(2), pos(1), testBridges(Bridge.of(0, 0), Bridge.of(1, 0)));
    }

    private BridgesSupplier testBridges(Bridge... bridges) {
        return new ManualBridgeSupplier(asList(bridges));
    }
}