package net.chandol.domain;

import net.chandol.domain.bridge.Bridges;
import net.chandol.domain.bridge.BridgesSupplier;
import net.chandol.domain.line.Lines;
import net.chandol.domain.player.Players;
import net.chandol.value.Positive;

import static net.chandol.value.Positive.pos;

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
