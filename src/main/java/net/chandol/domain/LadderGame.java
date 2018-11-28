package net.chandol.domain;

import net.chandol.domain.bridge.BridgesSupplier;
import net.chandol.domain.player.Players;
import net.chandol.request.LadderGameInitializeRequest;

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
