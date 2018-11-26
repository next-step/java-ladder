package net.chandol.domain;

import net.chandol.domain.bridge.Bridge;
import net.chandol.domain.bridge.ManualBridgeSupplier;
import net.chandol.domain.player.Players;
import org.junit.Test;

import static net.chandol.value.Positive.pos;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    public void 사다리만들기() {
        LadderGame ladderGame = new LadderGame(new ManualBridgeSupplier(Bridge.of(0,0)));
        Ladder ladder = ladderGame.initializeLadder(new Players("aaa", "bbbb"), pos(1));

        assertThat(ladder.hasBridge(pos(0), pos(0))).isTrue();
    }
}