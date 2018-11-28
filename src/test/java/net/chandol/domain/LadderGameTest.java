package net.chandol.domain;

import net.chandol.domain.bridge.Bridge;
import net.chandol.domain.bridge.ManualBridgeSupplier;
import net.chandol.domain.player.Players;
import net.chandol.request.LadderGameInitializeRequest;
import org.junit.Test;

import static net.chandol.value.Positive.pos;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    public void 사다리만들기() {
        LadderGame ladderGame = new LadderGame(new ManualBridgeSupplier(Bridge.of(0,0)));

        LadderGameInitializeRequest request = new LadderGameInitializeRequest(new Players("aaa", "bbbb"), pos(1));
        Ladder ladder = ladderGame.initializeLadder(request);

        assertThat(ladder.hasBridge(pos(0), pos(0))).isTrue();
    }
}