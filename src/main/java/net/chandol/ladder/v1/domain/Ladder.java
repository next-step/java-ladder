package net.chandol.ladder.v1.domain;

import net.chandol.ladder.v1.domain.bridge.Bridges;
import net.chandol.ladder.v1.domain.bridge.BridgesSupplier;
import net.chandol.ladder.v1.domain.line.Lines;
import net.chandol.ladder.v1.domain.player.Players;
import net.chandol.ladder.v1.value.Positive;

import static net.chandol.ladder.v1.value.Positive.pos;

public class Ladder {
    private Lines lines;
    private Positive height;
    private Bridges bridges;
    private Players players;

    public Ladder(Players players, Positive height, BridgesSupplier bridgesSupplier) {
        this.players = players;
        this.height = height;
        this.bridges = bridgesSupplier.createBridges(pos(players.size()), height);
        this.lines = new Lines(players, bridges);
    }

    public boolean hasBridge(Positive leftHandLine, Positive row) {
        return bridges.hasBridge(leftHandLine, row);
    }

    public Lines getLines() {
        return lines;
    }

    public Players getPlayers() {
        return players;
    }

    public Positive getHeight() {
        return this.height;
    }
}
