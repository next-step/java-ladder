package net.chandol.domain.bridge;

import net.chandol.value.Positive;

public interface BridgesSupplier {
    Bridges createBridges(Positive lineSize, Positive height);
}
