package net.chandol.ladder.v1.domain;

import net.chandol.ladder.v1.domain.bridge.Bridge;
import net.chandol.ladder.v1.domain.bridge.ManualBridgeSupplier;
import net.chandol.ladder.v1.domain.player.Players;
import net.chandol.ladder.v1.request.LadderGameInitializeRequest;
import org.junit.Test;

import static net.chandol.ladder.v1.value.Positive.pos;
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