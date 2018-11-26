package net.chandol.domain;

import net.chandol.domain.bridge.BridgesSupplier;
import net.chandol.domain.player.Players;
import net.chandol.value.Positive;

public class LadderGame {
    private BridgesSupplier bridgesSupplier;
    private Ladder ladder;
    private Players players;

    public LadderGame(BridgesSupplier bridgesSupplier) {
        this.bridgesSupplier = bridgesSupplier;
    }

    public Ladder initializeLadder(Players players, Positive height) {
        this.players = players;
        this.ladder =  new Ladder(players.size(), height, bridgesSupplier);
        return this.ladder;
    }

}
