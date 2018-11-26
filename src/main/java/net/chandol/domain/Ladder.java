package net.chandol.domain;

import net.chandol.domain.bridge.Bridges;
import net.chandol.domain.bridge.BridgesSupplier;
import net.chandol.value.Positive;

public class Ladder {
    private Lines lines;
    private Bridges bridges;

    public Ladder(Positive lineSize, Positive height, BridgesSupplier bridgesSupplier) {
        this.lines = new Lines(lineSize, height);
        this.bridges = bridgesSupplier.createBridges(lineSize, height);
    }

    public boolean hasBridge(Positive leftHandLine, Positive row) {
        return bridges.hasBridge(leftHandLine, row);
    }
}
