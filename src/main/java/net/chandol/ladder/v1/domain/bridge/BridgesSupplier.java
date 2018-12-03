package net.chandol.ladder.v1.domain.bridge;

import net.chandol.ladder.v1.value.Positive;

public interface BridgesSupplier {
    Bridges createBridges(Positive lineSize, Positive height);
}
