package net.chandol.ladder.v1.domain;

import net.chandol.ladder.v1.domain.bridge.BridgesSupplier;
import net.chandol.ladder.v1.domain.player.Players;
import net.chandol.ladder.v1.request.LadderGameInitializeRequest;

public class LadderGame {
    private BridgesSupplier bridgesSupplier;
    private Ladder ladder;

    public LadderGame(BridgesSupplier bridgesSupplier) {
        this.bridgesSupplier = bridgesSupplier;
    }

    public Ladder initializeLadder(LadderGameInitializeRequest request) {
        return this.ladder = new Ladder(request.getPlayers(), request.getHeight(), bridgesSupplier);
    }

    public Players getPlayers() {
        return ladder.getPlayers();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
